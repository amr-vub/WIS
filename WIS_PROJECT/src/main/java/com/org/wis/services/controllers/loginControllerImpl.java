package com.org.wis.services.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.org.wis.data.domain.User;
import com.org.wis.services.service.userService;


@Controller
@RequestMapping(value = "/login.do")
@SessionAttributes("user-id")
public class loginControllerImpl{
	
	@Autowired
	userService us;		
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute("login") User usr) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
