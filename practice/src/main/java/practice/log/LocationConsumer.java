package practice.log;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import practice.event.LocationEvent;
import practice.model.Location;

@Component
public class LocationConsumer implements ApplicationListener<LocationEvent> {

	@Override
	public void onApplicationEvent(LocationEvent event) {
		Location location = event.getLocation();
		System.out.println("X+Y="+location.sum());
		
	}

}
