package com.grupoDos.JavaBackendProject;

import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaBackendProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaBackendProjectApplication.class, args);
		RestaurantRepository repository = context.getBean(RestaurantRepository.class);

		//CREATE RESTAURANTS
		Restaurant restaurant1 = new Restaurant
				(null, "Piamonte", "piamonte@email.com", 999555111, "Calle Mar 21", "Bilbao", 12380, "www.piamonte.com");
		Restaurant restaurant2 = new Restaurant
				(null, "Napoli", "napoli@email.com", 888777444, "Calle Bota 11", "Bilbao", 12380, "www.napoli.com");
		Restaurant restaurant3 = new Restaurant
				(null, "Roma", "roma@email.com", 111222333, "Calle Clavo 56", "Bilbao", 12380, "www.roma.com");

		//SAVE RESTAURANTS
		repository.save(restaurant1);
		repository.save(restaurant2);
		repository.save(restaurant3);

		//RETRIEVE RESTAURANTS
		System.out.println(repository.findAll().size());

	}
}
