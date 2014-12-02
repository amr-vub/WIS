package com.org.wis.services.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.wis.services.service.userService;



@Controller
public class loginControllerImpl implements loginController {
	
	userService us;
	
	@Autowired
	public loginControllerImpl(userService us){
		this.us = us;
	}
	
	
	public String login(Model model) throws Exception {
		
		String username = "user1";
		String pw = "1234";
		
		String result = us.authenticateUser(username, pw) ? "success" : "login";
		
		if(!model.containsAttribute("user-id")) {
		      model.addAttribute("user-id", username);
		}
		
		
		
	    return result;
	}
	
}
