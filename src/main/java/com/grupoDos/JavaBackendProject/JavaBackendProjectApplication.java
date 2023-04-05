package com.grupoDos.JavaBackendProject;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.repository.CustomerRepository;
import com.grupoDos.JavaBackendProject.repository.RestaurantRepository;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class JavaBackendProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaBackendProjectApplication.class, args);
		RestaurantRepository repository = context.getBean(RestaurantRepository.class);
		CustomerRepository repoCustomer = context.getBean(CustomerRepository.class);

		// Create customer, if not exists
		Optional<Customer> opt = repoCustomer.findById(1L);
		if (opt.isEmpty()) {
			Customer customer = new Customer(
					null,
					"Cliente Ejemplo",
					"cliente@ejemplo.com",
					"1234",
					"111222333",
					"Calle Tal 3,5",
					"Ciudad",
					"00000"
			);

			repoCustomer.save(customer);
		}


		//CREATE RESTAURANTS
        /*
		Restaurant restaurant1 = new Restaurant
				(null, "Piamonte", "piamonte@email.com", 999555111, "Calle Mar 21", "Bilbao", 12380, "www.piamonte.com");
		Restaurant restaurant2 = new Restaurant
				(null, "Napoli", "napoli@email.com", 888777444, "Calle Bota 11", "Barcelona", 89562, "www.napoli.com");
		Restaurant restaurant3 = new Restaurant
				(null, "Roma", "roma@email.com", 111222333, "Calle Clavo 56", "Valencia", 23457, "www.roma.com");
		Restaurant restaurant4 = new Restaurant
				(null, "Trapela", "trapela@email.com", 85462137, "Calle Fura 56", "Madrid", 85236, "www.trapela.com");
		Restaurant restaurant5 = new Restaurant
				(null, "Mug", "mug@email.com", 888546234, "Calle Isla 56", "Sevilla", 96541, "www.mug.com");
		Restaurant restaurant6 = new Restaurant
				(null, "Calzone", "calzone@email.com", 897654321, "Calle Isla 56", "Sevilla", 96541, "www.calzone.com");

		//SAVE RESTAURANTS
		repository.save(restaurant1);
		repository.save(restaurant2);
		repository.save(restaurant3);
		repository.save(restaurant4);
		repository.save(restaurant5);
		repository.save(restaurant6);

		//RETRIEVE RESTAURANTS
		System.out.println(repository.findAll().size());

		//DELETE RESTAURANTS
		repository.deleteAll();
		System.out.println(repository.findAll().size());
		*/
	}
}
