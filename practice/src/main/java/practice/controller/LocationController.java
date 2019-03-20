package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import practice.dao.RouteDao;

@Controller
public class LocationController  {
	
	@Autowired
	RouteDao routeDao;
	
	@GetMapping("/locations")
	public String setLocations(Model model) {
		model.addAttribute("route", routeDao.getRoute());
		return "index";
	}	

}
