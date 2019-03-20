package practice.generator;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import practice.config.AppProperties;
import practice.event.LocationEvent;
import practice.model.Location;


@Component
public class VehicleGeneratoImpl implements VehicleGenerator {
	
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	@Autowired
	private AppProperties appProperties;
	
	private static Logger logger = LoggerFactory.getLogger(VehicleGeneratoImpl.class);
	


	@Override
	@Async
	public void generateLocation() {
		
		for(int i=1;i<15;i++) {
			Random rand = new Random();
			Location newLocation = new Location(rand.nextInt(appProperties.getCordinate_x_max()), 
					rand.nextInt(appProperties.getCordinate_y_max()),i);
			LocationEvent locationEvent = new LocationEvent(this, newLocation);
			applicationEventPublisher.publishEvent(locationEvent);
			template.convertAndSend("/topic/locations",locationEvent);
			try {
				Thread.sleep(appProperties.getValue_miliseconds());
			} catch (InterruptedException e) {
				logger.info("InterruptedException");
			}
		}
				
				
		
	}

}
