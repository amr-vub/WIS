package com.org.wis.services.controllers;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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
import com.org.wis.services.service.LocationService;
import com.org.wis.services.service.userService;

@SessionAttributes("id")
@Controller
public class EditArtistJobController {

	@Autowired
	userService userS;	
	
	@Autowired
	ArtistJobService artistS;
	
	@Autowired
	LocationService locationS;
	
	
	@RequestMapping(value = "/artistjob/add.do", method = RequestMethod.POST)
	public String saveArtistJobDetails(@ModelAttribute("artistjob") ArtistJob newAJ, @ModelAttribute("id") int id) throws Exception {
		
		artistS.addArtistJob(id, newAJ);
		
		return "redirect:/search.do";
	}
	
	@RequestMapping(value = "/artistjob/add.do", method = RequestMethod.GET)
	public String getNewArtistJob(Model model, @ModelAttribute("id") String id) {
		if(id !=null){		//user logged in
			ArtistJob aj = new ArtistJob();
			Location l = new Location();
			l.getArtistJobs().add(aj);
			aj.setArtLocation(l);
			model.addAttribute("artistjob", aj);
			return "addartistjob";
		}else return "redirect:/login.do";
		
	}
	
	@RequestMapping(value = "/artistjob/{artistjobid}/edit.do", method = RequestMethod.GET)
	public String getArtistJobDetails(Model model, @ModelAttribute("id") String id, @PathVariable int artistjobid) {
		
		if(id !=null){		//user logged in
			ArtistJob aj = artistS.getArtistJobById(artistjobid);
			if(aj != null){
				model.addAttribute("artistjob", aj);
				return "editartistjob";
			}else return "redirect:/search.do";
		}else return "redirect:/login.do";
		
	}
	
	@RequestMapping(value = "/artistjob/{artistjobid}/edit.do", method = RequestMethod.POST)
	public String updateArtistJobDetails(@ModelAttribute("artistjob") ArtistJob updatedAJ, @ModelAttribute("id") String id, @PathVariable int artistjobid) throws Exception {
		if(id !=null){		//user logged in
			updatedAJ.setArtistJobID(artistjobid);
			artistS.updateArtistJob(updatedAJ);
		}
		return "redirect:/search.do";
	}
	
	@RequestMapping(value = "/artistjob/{artistjobid}/delete.do", method = RequestMethod.POST)
	public void deleteArtistJob(Model model, @ModelAttribute("id") String id, @PathVariable int artistjobid) {
		
		if(id !=null){		//user logged in
			artistS.deleteArtistJob(artistjobid);
		}
		
	}
}
