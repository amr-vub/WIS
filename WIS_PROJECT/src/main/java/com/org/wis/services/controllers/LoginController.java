package com.org.wis.services.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.userService;


/*
 * 
 * NOTE: For the controllers, you dnt need to make an interface and implement it.
 * 
 */

@SessionAttributes("id")
@Controller
public class LoginController{
	
	@Autowired
	userService userS;		
	
	
	@RequestMapping(value = "/login.do", params="login" ,method = RequestMethod.POST)
	public String login( @ModelAttribute("myuser") UserAuthentication userA, Model model) throws Exception {

		User u = userS.authenticateUser(userA);
		
		if(u != null){
			//user login valid -> write id in session
			model.addAttribute("id", u.getUserId());
			//System.out.println(userA.getEmail() + userA.getPassword() + "   " + u);
			return "redirect:/search.do";
		}else{
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(SessionStatus status){
		status.setComplete();	//clears attributes from session
		return "redirect:/login.do";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginGet(Model model) {
		
		model.addAttribute("myuser", new UserAuthentication());	
		
		return "login";
	}
	
	@RequestMapping(value = "/login.do" , params="register")
	public String register(){
		
		return "redirect:/register.do";
	}
	
	
	
}