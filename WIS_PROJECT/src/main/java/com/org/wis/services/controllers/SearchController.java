package com.org.wis.services.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.SearchService;
import com.org.wis.services.service.userService;

public class SearchController {


	@Autowired
	SearchService searchS;		
	
	@RequestMapping(value = "/search.do", method = RequestMethod.POST)
	public void search(Model model) {
		
		//return searchS.searchArtist/Booker(alias, nbrResults)
		
	}
	
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public void searchGet(Model model) {
		
		
		
	}
	
	
}
