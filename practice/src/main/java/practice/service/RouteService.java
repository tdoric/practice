package practice.service;

import java.util.List;

import practice.model.Location;

public interface RouteService {
	
	public List<Location> loadRoute();
	public void checkRoute(Location generatedLocation);

}
