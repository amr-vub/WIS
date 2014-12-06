package com.org.wis.services.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.userService;


/*
 * 
 * NOTE: For the controllers, you dnt need to make an interface and implement it.
 * 
 */

@SessionAttributes("userid")
@Controller
public class LoginControllerImpl{
	
	@Autowired
	userService userS;		
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(Model model) throws Exception {
		// more elegant: @ModelAttribute("myuser") UserAuthentication userA
		
		Map<String, Object> map  = model.asMap();
		UserAuthentication userA = (UserAuthentication)map.get("myuser");
		//the userAuthentication should have email instead of username
		
		User u = userS.authenticateUser(userA.getEmail(), userA.getPassword());
		
		if(u !=null){
			//this model attribute (int with UserId) is automatically written to Session 
			//object because of annotation @SessionAttributes("userid"). 
			//User id is stored in session to identify user when surfing on website
			model.addAttribute("userid", u.getUserId()); // works with int ?  
			//e.g. goto link /{u.getUserId()} to show users personal page
			return "success";
		}else{
		return "failed";
		};
	}
	
	@RequestMapping(value = "/logout.do")
	public String logout(SessionStatus status){
		status.setComplete();	//clears attributes from session
		return "logout";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
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