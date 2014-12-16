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
import com.org.wis.data.domain.User;
import com.org.wis.services.service.userService;

@SessionAttributes("viewId")
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
	
	@RequestMapping(value = "/mainview/user/{searchId}.do")
	public @ResponseBody String getArtistJobs(@ModelAttribute("id") int id, 
			@PathVariable int searchId, Model model) throws Exception{
			
		model.addAttribute("viewId", searchId);
		
		return "mainview";
	}
	
}
