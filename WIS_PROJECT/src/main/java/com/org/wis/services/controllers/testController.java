/*
 <dependency>  
		 <groupId>org.codehaus.jackson</groupId>  
		 <artifactId>jackson-mapper-asl</artifactId>  
		 <version>1.9.10</version>  
</dependency>
		
 */






package com.org.wis.services.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.wis.data.domain.User;

@Controller
public class testController {
	
	
	@RequestMapping(value = "/test1")
	@ResponseBody
	public User test1(){
		
		User u = new User();
		u.setUserName("Johannes");
		u.setGSM("1234");
		return u;
	}
	
	@RequestMapping(value = "/test2")
	@ResponseBody
	public User[] test2(){
		
		User u1 = new User();
		u1.setUserName("Johannes");
		u1.setGSM("1234");
		
		User u2 = new User();
		u2.setUserName("Sepp");
		u2.setGSM("4321");
		
		User[] users = new User[]{u1,u2};
		
		return users;
	}
	
	@RequestMapping(value = "/test3")
	@ResponseBody
	public String test3(){
		return "this is a String";
	}
	
	
	
	
	
	
	
}
