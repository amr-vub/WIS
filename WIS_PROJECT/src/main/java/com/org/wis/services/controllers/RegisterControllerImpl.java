package com.org.wis.services.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.userService;

public class RegisterControllerImpl {

	@Autowired
	userService userS;		
	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public @ResponseBody String addUser(Model model) throws Exception {
		
		Map<String, Object> map  = model.asMap();
		User user = (User)map.get("user");
		
		//Because of @ResponseBody the Strings should be returned directly (conversion done by spring) json?
		// probably needs
		//   -- jackson-annotations-x.x.x.jar
	    // -- jackson-core-x.x.x.jar
	    // -- jackson-databind-x.x.x.jar
		if(userS.addUser(user)){
			return "new user account created";
		}else{
			return "user with this email already exists";
		}
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		UserAuthentication ua = new UserAuthentication();
		user.setUserAuthentication(ua);
		model.addAttribute("user", new User());	
		
		return "register";
	}
	
}
