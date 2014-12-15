package com.org.wis.services.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterSuccesController {

	@RequestMapping(value = "/registersucces.do")
	public String registerSuccess(Model model) {
				
		return "registersucces";
	}

}
