package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import practice.dao.RouteDao;
import practice.event.LocationEvent;
import practice.model.Location;
import practice.model.Msg;

@Component
public class RouteServiceImpl implements RouteService,ApplicationListener<LocationEvent> {
    
	@Autowired
    RouteDao routeDao;
	@Autowired
	SimpMessagingTemplate template;
	
	@Override
	public void onApplicationEvent(LocationEvent event) {
		this.checkRoute(event.getLocation());
		
	}
	
	@Override
	public void checkRoute(Location generatedLocation) {
			Location definiedLocation = routeDao.getLocation(generatedLocation.getStep());
			if(definiedLocation.equals(generatedLocation)) {
				template.convertAndSend("/topic/status",new Msg("The vehicle is on route!",generatedLocation.getStep(),true));
			}else {
				template.convertAndSend("/topic/status",new Msg("Wrong way!",generatedLocation.getStep(),false));
			}
		}

}
