package com.org.wis.services.controllers;

import java.util.List;
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
import com.org.wis.data.domain.BookerJob;
import com.org.wis.data.domain.Location;
import com.org.wis.data.domain.User;
import com.org.wis.data.domain.UserAuthentication;
import com.org.wis.services.service.BookerJobService;
import com.org.wis.services.service.LocationService;
import com.org.wis.services.service.userService;

@SessionAttributes("id")
@Controller
public class EditBookerJobController {

	@Autowired
	userService userS;	
	
	@Autowired
	BookerJobService bookerS;
	
	@Autowired
	LocationService locationS;
	
	
	@RequestMapping(value = "/bookerjob/add.do", method = RequestMethod.POST)
	public String saveBookerJobDetails(@ModelAttribute("bookerjob") BookerJob newBJ, @ModelAttribute("id") int id) throws Exception {
		
		bookerS.addBookerJob(id, newBJ);
		
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/bookerjob/add.do", method = RequestMethod.GET)
	public String getNewBookerJob(Model model, @ModelAttribute("id") String id) {
		if(id !=null){		//user logged in
			BookerJob bj = new BookerJob();
			Location l = new Location();
			l.getBookerJobs().add(bj);
			bj.setBookerLocation(l);
			model.addAttribute("bookerjob", bj);
			return "addbookerjob";
		}else return "redirect:/login.do";
		
	}
	
	@RequestMapping(value = "/bookerjob/{bookerjobid}/edit.do", method = RequestMethod.GET)
	public String getBookerJobDetails(Model model, @ModelAttribute("id") String id, @PathVariable int bookerjobid) {
	
		if(id !=null){		//user logged in
			BookerJob bj = bookerS.getBookerJobById(bookerjobid);
			if(bj != null){
				model.addAttribute("bookerjob", bj);
				return "editbookerjob";
			}else return "redirect:/search.do";
		}else return "redirect:/login.do";
		
	}
	
	@RequestMapping(value = "/bookerjob/{bookerjobid}/edit.do", method = RequestMethod.POST)
	public String updateBookerJobDetails(@ModelAttribute("bookerjob") BookerJob updatedBJ, @ModelAttribute("id") String id, @PathVariable int bookerjobid) throws Exception {
		
		if(id !=null){		//user logged in
			updatedBJ.setBookerJob(bookerjobid);
			bookerS.updateBookerJob(updatedBJ);
		}
		return "redirect:/mainview.do";
	}
	
	@RequestMapping(value = "/bookerjob/{bookerjobid}/delete.do", method = RequestMethod.POST)
	public void deleteBookerJob(Model model, @ModelAttribute("id") String id, @PathVariable int bookerjobid) {
		
		if(id !=null){		//user logged in
			bookerS.deleteBookerJob(bookerjobid);
		}
		
	}
}
