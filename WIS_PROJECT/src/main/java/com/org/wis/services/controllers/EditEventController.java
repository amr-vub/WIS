package com.org.wis.services.controllers;

import com.org.wis.data.domain.Event;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;




import com.org.wis.data.domain.ArtistJob;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.ArtistJobService;
import com.org.wis.services.service.EventService;
import com.org.wis.services.service.userService;

@SessionAttributes("id")
@Controller
public class EditEventController {

	@Autowired
	userService userS;	
	
	@Autowired
	EventService eventS;
	
	
	
	@RequestMapping(value = "/event/add.do", method = RequestMethod.POST)
	public String saveEventDetails(@ModelAttribute("event") Event event, @ModelAttribute("id") String id) throws Exception {
		
		eventS.saveEvent(event);
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/event/add.do", method = RequestMethod.GET)
	public String getNewEvent(Model model, @ModelAttribute("id") String id) {
		if(id !=null){		//user logged in
			Event ev = new Event();
			model.addAttribute("event", ev);
			return "addevent";
		}else return "redirect:/login.do";
	}
	
	@RequestMapping(value = "/event/{eventid}/edit.do", method = RequestMethod.GET)
	public String getEvent(Model model, @ModelAttribute("id") String id, @PathVariable int eventid) {
		System.out.println("edit event no" + eventid);
		if(id !=null){		//user logged in
			Event ev = eventS.getEventById(eventid);
			if(ev != null){
				model.addAttribute("event", ev);
				return "editevent";
			}else return "redirect:/mainview.do";
		}else return "redirect:/login.do";
		
	}
	
	@RequestMapping(value = "/event/{eventid}/edit.do", method = RequestMethod.POST)
	public String updateEvent(@ModelAttribute("event") Event updatedEv, @ModelAttribute("id") String id, @PathVariable int eventid) throws Exception {
		System.out.println("editevent44444444444444");
		updatedEv.setEventID(eventid);
		eventS.updateEvent(updatedEv);
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/event/{eventid}/delete.do", method = RequestMethod.GET)
	public void deleteEvent(Model model, @ModelAttribute("id") int id, @PathVariable int eventid) {
		
		if(id >0){		//user logged in
			System.out.println("delete event with id" + eventid);
			eventS.deleteEvent(id,eventid);
			System.out.println("deleted!");
		}
		
	}
}
