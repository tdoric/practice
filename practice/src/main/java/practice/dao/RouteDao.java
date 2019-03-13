package practice.dao;

import java.util.List;

import practice.model.Location;

public interface RouteDao {
	
	public List<Location> getRoute();
	public void insertLogLocation(Location location);
	public Location getLocation(int idLocation);

}
