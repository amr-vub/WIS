package com.org.wis.services.controllers;

import java.util.List;

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
import com.org.wis.services.service.userService;

@SessionAttributes({"id", "viewId","eventId", "viewevent"})
@Controller
public class MainViewController {


	ObjectMapper mapper;
	
	@Autowired
	userService userservice;
	
	public MainViewController(){
		mapper = new ObjectMapper();
	}
	
	@RequestMapping(value = "/mainview.do", method = RequestMethod.GET)
	public  String mainViewRender(Model model){			
					
		return "mainview";		
	}
	
	@RequestMapping(value = "/mainview/user/getUser.do")
	public @ResponseBody String getUser(@ModelAttribute("viewId") int viewId
			) throws Exception{
			
		User us = userservice.getUserById(viewId);
		
		return mapper.writeValueAsString(us);
	}
	
	@RequestMapping(value = "/mainview/user/getArtist.do")
	public @ResponseBody String getArtistJobs(@ModelAttribute("viewId") int viewId
			) throws Exception{
			
		
		List<ArtistJob> lis = userservice.getUserArtistJobs(viewId);
		
		return mapper.writeValueAsString(lis);
	}
	
	@RequestMapping(value = "/mainview/artist/{userId}.do")
	public String SetArtist(@ModelAttribute("viewId") int viewId,
			@PathVariable int userId, Model model) throws Exception{
					
		model.addAttribute("viewId", userId);		
		model.addAttribute("viewevent", false);
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/mainview/user/getBooker.do")
	public @ResponseBody String getBooker(@ModelAttribute("viewId") int viewId
			) throws Exception{
					
		List<BookerJob> lis = userservice.getUserBookerJob(viewId);
		
		return mapper.writeValueAsString(lis);
	}
	
	@RequestMapping(value = "/mainview/booker/{userId}.do")
	public String SetBooker(@ModelAttribute("viewId") int viewId,
			@PathVariable int userId, Model model) throws Exception{
					
		model.addAttribute("viewId", userId);			
		model.addAttribute("viewevent", false);
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/mainview/user/checkSelf.do")
	public @ResponseBody String checkSelf(@ModelAttribute("viewId") int viewId, @ModelAttribute("id") int id
			) throws Exception{
								
		return mapper.writeValueAsString(viewId == id);
	}
	
	@RequestMapping(value = "/mainview/event/{eventId}.do")
	public String SetEvent(@ModelAttribute("viewId") int viewId,
			@PathVariable int eventId, Model model) throws Exception{
					
		model.addAttribute("eventId", eventId);
		model.addAttribute("viewevent", true);		
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/mainview/event/checkViewType.do")
	public @ResponseBody String checkViewType(@ModelAttribute("viewevent") boolean viewevent) throws Exception{
								
		return mapper.writeValueAsString(viewevent);
	}
	
}
