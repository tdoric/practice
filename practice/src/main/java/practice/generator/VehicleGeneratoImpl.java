package practice.generator;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import practice.event.LocationEvent;
import practice.log.LocationConsumer;
import practice.model.Location;


@Component
public class VehicleGeneratoImpl implements VehicleGenerator {
	
	@Autowired
	LocationConsumer locationConsumer;
	@Autowired
	SimpMessagingTemplate template;
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
	public static final int X_CORDINATE_MAX = 11;
	public static final int Y_CORDINATE_MAX = 11; 
	public static final int VALUE_MILISECOND = 10000;

	@Override
	public void generateLocation() {
		
		for(int i=1;i<15;i++) {
			Random rand = new Random();
			Location newLocation = new Location(rand.nextInt(X_CORDINATE_MAX), rand.nextInt(Y_CORDINATE_MAX),i);
			LocationEvent locationEvent = new LocationEvent(this, newLocation);
			applicationEventPublisher.publishEvent(locationEvent);
			template.convertAndSend("/topic/greetings",locationEvent);
			try {
				Thread.sleep(VALUE_MILISECOND);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
				
				
		
	}

}
