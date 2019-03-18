package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import practice.dao.RouteDao;
import practice.generator.VehicleGenerator;
import practice.model.Location;

@Controller
public class TestController  {
	
	@Autowired
	RouteDao routeDao;
	@Autowired
	VehicleGenerator vehicleGenerator;
	
	
	
	@GetMapping("/generate")
	public void start(){
		vehicleGenerator.generateLocation();
	
	}
	
	@GetMapping("/locations")
	public String setLocations(Model model) {
		model.addAttribute("route", routeDao.getRoute());
		return "index";
	}
	
	@MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Location greeting(Location location) throws Exception {
        return location;
    }
	
	

}
