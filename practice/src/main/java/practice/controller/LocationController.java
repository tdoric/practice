package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import practice.dao.RouteDao;
import practice.generator.VehicleGenerator;

@Controller
public class LocationController  {
	
	@Autowired
	RouteDao routeDao;
	@Autowired
	VehicleGenerator vehicleGenerator;
	
	
	
	@PostMapping("/generate")
	public void start(){
		vehicleGenerator.generateLocation();
	
	}
	
	@GetMapping("/locations")
	public String setLocations(Model model) {
		model.addAttribute("route", routeDao.getRoute());
		return "index";
	}
	
	
//	@MessageMapping("/hello")
//    @SendTo("/topic/locations")
//    public Location greeting(Location location) throws Exception {
//        return location;
//    }
	
	

}
