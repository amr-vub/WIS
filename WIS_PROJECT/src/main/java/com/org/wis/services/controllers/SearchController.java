package com.org.wis.services.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.ArtistJobService;
import com.org.wis.services.service.SearchService;
import com.org.wis.services.service.userService;




@SessionAttributes("id")
@Controller
public class SearchController {	
	
	@Autowired
	SearchService searchS;
	
	@Autowired
	ArtistJobService artistS;
	
	ObjectMapper mapper;
	
	public SearchController(){
		mapper = new ObjectMapper();
	}
	
	
	@RequestMapping(value = "/search/artist/{nbrResults}/{searchterm}.do")
	public @ResponseBody String searchArtist(@PathVariable String searchterm, @PathVariable int nbrResults) throws Exception{
		
		System.out.println("searchterm:" + searchterm + nbrResults );
		List<ArtistJob> artistList = new ArrayList<ArtistJob>();// searchS.searchArtist(searchterm, nbrResults);
		
		
		ArtistJob a1 = new ArtistJob();
		a1.setAliase("max1");
		a1.setArtFrom("music");
		artistList.add(a1);
		ArtistJob a2 = new ArtistJob();
		a2.setAliase("max2");
		a2.setArtFrom("music");
		artistList.add(a2);
		ArtistJob a3 = new ArtistJob();
		a3.setAliase("max3");
		a3.setArtFrom("music");
		artistList.add(a3);
		
		
		return mapper.writeValueAsString(artistList);
	}
	
	@RequestMapping(value = "/search/booker/{nbrResults}/{searchterm}.do")
	public @ResponseBody String searchBooker(@PathVariable String searchterm, @PathVariable int nbrResults) throws Exception{
		
		System.out.println("searchterm:" + searchterm + nbrResults );
		//List<BookerJob> bookerList = searchS.searchBooker(searchterm, nbrResults>0?nbrResults:0);
		
		List<BookerJob>bookerList = new ArrayList<BookerJob>();
		
		for(int i=0; i<4; i++){
			BookerJob a1 = new BookerJob();
			a1.setLabel("max" + i);
			a1.setDescription("music");
			bookerList.add(a1);
		}
		return mapper.writeValueAsString(bookerList);
	}
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String getsuccess(@ModelAttribute("id") String id) {
		
		System.out.println("search page loaded by user: " + id);
		
		return "search";
	}	
	
	@RequestMapping(value = "/search/rank/{artistJobId}/{artistJobRanking}.do")
	public @ResponseBody String addRanking(@ModelAttribute("id") int uid, @PathVariable int artistJobId, @PathVariable int artistJobRanking) throws Exception {
		System.out.println("!!!");
		artistS.addRanking(artistJobId, artistJobRanking, uid);
		String s = String.valueOf(artistS.getRanking(artistJobId));
		System.out.println("the new ranking is " +s);
		return mapper.writeValueAsString(artistS.getRanking(artistJobId));
	}
}
