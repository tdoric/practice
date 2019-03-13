package practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import practice.dao.RouteDao;
import practice.event.LocationEvent;
import practice.model.Location;

@Component
public class RouteServiceImpl implements RouteService,ApplicationListener<LocationEvent> {
    
	@Autowired
    RouteDao routeDao;
	
	@Override
	public void onApplicationEvent(LocationEvent event) {
		this.checkRoute(event.getLocation());
		
	}

	@Override
	public List<Location> loadRoute() {
		return routeDao.getRoute();
	}

	@Override
	public void checkRoute(Location generatedLocation) {
			Location definiedLocation = routeDao.getLocation(generatedLocation.getStep());
			if(definiedLocation.equals(generatedLocation)) {
				System.out.println("The vehicle is on route!");
			}else {
				System.out.println("Wrong way!");
			}
		}

}
