package practice.generator;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import practice.event.LocationEvent;
import practice.log.LocationConsumer;
import practice.model.Location;


@Component
public class VehicleGeneratoImpl implements VehicleGenerator {
	
	@Autowired
	LocationConsumer locationConsumer;
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
	public static final int X_CORDINATE_MAX = 10;
	public static final int Y_CORDINATE_MAX = 10; 
	public static final int VALUE_MILISECOND = 10000;

	@Override
	@Scheduled(fixedRate = VALUE_MILISECOND)
	public void generateLocation() {
		Random rand = new Random();
		Location newLocation = new Location(rand.nextInt(X_CORDINATE_MAX), rand.nextInt(Y_CORDINATE_MAX));
		LocationEvent locationEvent = new LocationEvent(this, newLocation);
		applicationEventPublisher.publishEvent(locationEvent);
	}

}
