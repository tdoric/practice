package practice.event;

import org.springframework.context.ApplicationEvent;

import practice.model.Location;

public class LocationEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location ;

	public LocationEvent(Object source, Location location) {
		super(source);
		this.location=location;
	}

	public Location getLocation() {
		return location;
	}

}
