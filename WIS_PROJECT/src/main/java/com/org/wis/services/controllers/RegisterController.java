package com.org.wis.services.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.userService;


@Controller
public class RegisterController {

	@Autowired
	userService userS;		
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u) throws Exception {
		if(userS.addUser(u)) return "redirect:/login.do";
		return "register";
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String getRegister(Model model) {
	
		User u = new User();
		UserAuthentication uA = new UserAuthentication();
		u.setUserAuthentication(new UserAuthentication());
		uA.setUser(u);
		model.addAttribute("user", u);	
		
		return "register";
	}
	
}
