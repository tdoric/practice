package practice.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import practice.event.LocationEvent;
import practice.model.Location;

@Component
public class LocationConsumer implements ApplicationListener<LocationEvent> {
	
	private static Logger logger = LoggerFactory.getLogger(LocationConsumer.class);

	@Override
	public void onApplicationEvent(LocationEvent event) {
		Location location = event.getLocation();
		logger.info("X+Y="+location.sum());
	}

}
