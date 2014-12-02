package com.org.wis.services.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user-id")
public interface loginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model) throws Exception;

	
}
