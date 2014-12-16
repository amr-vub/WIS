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

@SessionAttributes({"Id", "viewId"})
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
	
	@RequestMapping(value = "/mainview/user/getBooker.do")
	public @ResponseBody String getBooker(@ModelAttribute("viewId") int viewId
			) throws Exception{
					
		List<BookerJob> lis = userservice.getUserBookerJob(viewId);
		
		return mapper.writeValueAsString(lis);
	}
	
}
