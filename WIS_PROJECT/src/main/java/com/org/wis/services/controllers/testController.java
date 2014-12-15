
package com.org.wis.services.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
//import com.org.wis.data.domain.testUser;

@SessionAttributes("email")
@Controller
public class testController {	
	
	public ObjectMapper mapper;
	
	public testController(){
		mapper = new ObjectMapper();
	}
	
	
	@RequestMapping(value = "/test1.do", method = RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public String test1() throws Exception{
		
		UserAuthentication u = new UserAuthentication();
		//u.setEmail("a@b.com");
		u.setPassword("1234");
		
	
		
		return mapper.writeValueAsString( u);
	}
	
	@RequestMapping(value = "/test2.do", method = RequestMethod.POST)
	@ResponseBody
	public String test2(User u){
		String s2= "user: " + u.getUserName() + " gsm: " + u.getGSM() + " email: " + u.getEmail();
		System.out.println(s2);
		return "server got information: " + s2;
	}
	
	@RequestMapping(value = "/test3.do")
	@ResponseBody
	public void test3(String id){
		System.out.println("submitted id:" + id);
	}
	
	@RequestMapping(value = "/search/{term}.do")
	public @ResponseBody String search(@PathVariable String term) throws Exception{
		System.out.println("searchterm:" + term);
		List<User> userList = new ArrayList<User>();
		User u1 = new User();
		u1.setEmail(term);
		u1.setGSM("123");
		User u2 = new User();
		u2.setEmail("c@d.com");
		u2.setGSM("567");
		userList.add(u1);
		userList.add(u2);
		 
		mapper.writeValueAsString( userList);
		return mapper.writeValueAsString(userList);
	}
	
	@RequestMapping(value = "/success.do", method = RequestMethod.GET)
	public String getsuccess(@ModelAttribute("email") String email) {
		
		System.out.println("success got from session" + email);
		
		return "success";
	}
	
	
}


/*try {

// convert user object to json string, and save to a file

s=mapper.writeValueAsString( u);

// display to console
System.out.println(s);

} catch (JsonGenerationException e) {

e.printStackTrace();

} catch (JsonMappingException e) {

e.printStackTrace();

} catch (IOException e) {

e.printStackTrace();

}

*/
