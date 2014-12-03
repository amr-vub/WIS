package com.org.wis.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.userService;


/*
 * 
 * NOTE: For the controllers, you dnt need to make an interface and implement it.
 * 
 */

@Controller
@RequestMapping(value = "/login.do")
@SessionAttributes("user-id")
public class loginControllerImpl{
	
	@Autowired
	userService us;		
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@ModelAttribute("login") User usr) throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public String listPersons(Model model) {
		/*	
		 * here you get the model object "myuser" (which is specified by the 'modelAttribute'
		 * in the form tag in jsp). Then you specify which object it should be mapped to.
		 * Here I choose as an example UserAuthentication domain object.
		 * Finally, you return the name of the redirected page
		 */
		model.addAttribute("myuser", new UserAuthentication());	
		
		return "login";
	}
	
}
