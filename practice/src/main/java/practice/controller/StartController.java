package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import practice.generator.VehicleGenerator;

@RestController
public class StartController {
	
	@Autowired
	VehicleGenerator vehicleGenerator;
	
	@PostMapping("/generate")
	public void start(){
		vehicleGenerator.generateLocation();
	
	}

}
