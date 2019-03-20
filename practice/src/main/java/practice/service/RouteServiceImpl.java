package practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import practice.config.AppProperties;
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
	@Autowired
	AppProperties appProperties;
	
	@Override
	public void onApplicationEvent(LocationEvent event) {
		this.checkRoute(event.getLocation());
		
	}
	
	@Override
	public void checkRoute(Location generatedLocation) {
			Location definiedLocation = routeDao.getLocation(generatedLocation.getStep());
			if(definiedLocation.equals(generatedLocation)) {
				template.convertAndSend("/topic/status",new Msg(appProperties.getMsg_on_route(),generatedLocation.getStep(),true));
			}else {
				template.convertAndSend("/topic/status",new Msg(appProperties.getMsg_wrong_way(),generatedLocation.getStep(),false));
			}
		}

}
