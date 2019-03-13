package practice.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import practice.dao.RouteDao;
import practice.event.LocationEvent;

@Component
public class LocationLog implements ApplicationListener<LocationEvent> {
	
	@Autowired
	RouteDao routeDao;

	@Override
	public void onApplicationEvent(LocationEvent event) {
		routeDao.insertLogLocation(event.getLocation());
		
	}

}
