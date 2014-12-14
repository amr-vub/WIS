package com.org.wis.services.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.userService;

@SessionAttributes("id")
@Controller
public class EditUserController {

	@Autowired
	userService userS;		
	
	@RequestMapping(value = "/edituser.do", method = RequestMethod.POST)
	public String setUserDetails(@ModelAttribute("user") User updatedUser, @ModelAttribute("id") String id) throws Exception {
		User dbUser = userS.getUserByEmail(id);
		//System.out.println("email: id:" + id +" updated: email:" + updatedUser.getEmail() + " auth" + updatedUser.getUserAuthentication().getEmail());
		dbUser.getUserAuthentication().setEmail(updatedUser.getEmail());
		dbUser.setUserName(updatedUser.getUserName());
		dbUser.setGSM(updatedUser.getGSM());
		dbUser.setEmail(updatedUser.getEmail());
		
		// Then we should commit the update to the DB
		userS.updateUser(dbUser);
		
		return "redirect:/search.do";
	}
	
	@RequestMapping(value = "/edituser.do", method = RequestMethod.GET)
	public String getUserDetails(Model model, @ModelAttribute("id") String id) {
		
		if(id !=null){
			//user logged in
			User u = userS.getUserByEmail(id);
			//System.out.println("id from session: " + id + "found user from db:" + u.getEmail());
			model.addAttribute("user", u);
			return "edituser";
		}else return "redirect:/login.do";
		
	}
	
}
