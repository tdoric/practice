package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import practice.generator.VehicleGenerator;

@SpringBootApplication
@EnableScheduling
public class Application implements ApplicationRunner    {
	
	@Autowired
	VehicleGenerator vehicleGenerator;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		vehicleGenerator.generateLocation();
	}

	

}
