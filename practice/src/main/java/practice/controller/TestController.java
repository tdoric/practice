package practice.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.RestController;

import practice.event.LocationEvent;

@RestController
public class TestController implements ApplicationListener<LocationEvent> {

	@Override
	public void onApplicationEvent(LocationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
