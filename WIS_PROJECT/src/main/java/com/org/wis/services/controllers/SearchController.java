package com.org.wis.services.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.org.wis.data.dao.IUserManager;
import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Event;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.ArtistJobService;
import com.org.wis.services.service.EventService;
import com.org.wis.services.service.SearchService;
import com.org.wis.services.service.userService;

@SessionAttributes({"id", "eventId"})
@Controller
public class SearchController {	
	
	@Autowired
	SearchService searchS;
	
	@Autowired
	ArtistJobService artistS;
	
	@Autowired 
	userService userS;
	
	@Autowired
	EventService eventS;
	
	ObjectMapper mapper;
	
	public SearchController(){
		mapper = new ObjectMapper();
	}
	
	@RequestMapping(value = "/search/user/{userid}.do")
	public @ResponseBody String getUser(@ModelAttribute("id") int id, @PathVariable int userid) throws Exception{
		
		User u = userS.getUserById(userid);
		return mapper.writeValueAsString(u);
	}
	
	@RequestMapping(value = "/search/user.do")
	public @ResponseBody String getUser(@ModelAttribute("id") int id) throws Exception{
		
		User u = userS.getUserById(id);
		return mapper.writeValueAsString(u);
	}
	
	@RequestMapping(value = "/search/artist/{nbrResults}/{searchterm}.do")
	public @ResponseBody String searchArtist(@PathVariable String searchterm, @PathVariable int nbrResults) throws Exception{
		
		List<ArtistJob> artistList = searchS.searchArtist(searchterm, nbrResults); //get an DB error here
		
		return mapper.writeValueAsString(artistList);
	}
	
	@Transactional
	@RequestMapping(value = "/search/getartistjobs.do")
	public @ResponseBody String getArtistJobs(@ModelAttribute("id") int id) throws Exception{
		
		List<ArtistJob> ajs = userS.getUserArtistJobs(id); 
		
		return mapper.writeValueAsString(ajs);
	}
	
	
	@RequestMapping(value = "/search/booker/{nbrResults}/{searchterm}.do")
	public @ResponseBody String searchBooker(@PathVariable String searchterm, @PathVariable int nbrResults) throws Exception{
		
		List<BookerJob> bookerList = searchS.searchBooker(searchterm, nbrResults); //get an DB error here
		
		return mapper.writeValueAsString(bookerList);
	}
	
	@RequestMapping(value = "/search/event/{nbrResults}/{searchterm}.do")
	public @ResponseBody String searchEvent(@PathVariable String searchterm, @PathVariable int nbrResults) throws Exception{
		
		List<Event> eventList = searchS.searchEvent(searchterm, nbrResults );
		return mapper.writeValueAsString(eventList);
	}
	
	@RequestMapping(value = "/search/artist/{nbrResults}/{searchterm}/{lon}/{lat}/{radiuskm}.do")
	public @ResponseBody String searchArtistInArea(@PathVariable String searchterm, @PathVariable int nbrResults,
			@PathVariable double lon, @PathVariable double lat, @PathVariable double radiuskm) throws Exception{
		
		List<ArtistJob> artistList = new ArrayList<ArtistJob>();//searchS.searchArtistInArea(searchterm, nbrResults,lon,lat,radiuskm );
		
		return mapper.writeValueAsString(artistList);
	}
	
	@RequestMapping(value = "/search/booker/{nbrResults}/{searchterm}/{lon}/{lat}/{radiuskm}.do")
	public @ResponseBody String searchBookerInArea(@PathVariable String searchterm, @PathVariable int nbrResults,
			@PathVariable double lon, @PathVariable double lat, @PathVariable double radiuskm) throws Exception{
		
		//List<BookerJob> bookerlist = searchS.searchBookerInArea(searchterm, nbrResults,lon,lat,radiuskm );
		return null;//mapper.writeValueAsString(bookerlist);
	}
	
	@RequestMapping(value = "/search/event/{nbrResults}/{searchterm}/{lon}/{lat}/{radiuskm}.do")
	public @ResponseBody String searchEventInArea(@PathVariable String searchterm, @PathVariable int nbrResults,
			@PathVariable double lon, @PathVariable double lat, @PathVariable double radiuskm) throws Exception{
		
		List<Event> eventList = searchS.searchEventsInArea(searchterm, nbrResults,lon,lat,radiuskm );
		return mapper.writeValueAsString(eventList);
	}
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String getsuccess(@ModelAttribute("id") String id) {
		
		System.out.println("search page loaded by user: " + id);
		return "search";
	}	
	
	@RequestMapping(value = "/search/rank/{artistJobId}/{artistJobRanking}.do")
	public @ResponseBody String addRanking(@ModelAttribute("id") int uid, 
			@PathVariable int artistJobId, @PathVariable int artistJobRanking) throws Exception {
		
		artistS.addRanking(artistJobId, artistJobRanking, uid);
		return mapper.writeValueAsString(artistS.getRanking(artistJobId));
	}
	

	@RequestMapping(value = "/search/subscribeartist/{aid}.do")
	public String subscribeArtist(@ModelAttribute("id") int uid, 
			@PathVariable int aid, @ModelAttribute("eventId") int eventId) throws Exception {
		eventS.addArtistToEvent(aid, eventId);
		return "redirect:/booked.do";
	}
	
	@RequestMapping(value = "/booked.do")
	public String booked() throws Exception {
		
		return "booksucces";
	}
	@RequestMapping(value = "/bookedOk.do")
	public String bookedOk() throws Exception {
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/search/subscribebooker/{bid}/{eid}.do")
	public @ResponseBody String subscribeBooker(@ModelAttribute("id") int uid, 
			@PathVariable int bid, @PathVariable int eid) throws Exception {
		
		eventS.addBookerToEvent(bid, eid);
		return mapper.writeValueAsString("ok");
	}
	
}
