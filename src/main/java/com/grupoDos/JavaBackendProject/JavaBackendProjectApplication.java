package com.grupoDos.JavaBackendProject;

import com.grupoDos.JavaBackendProject.model.*;
import com.grupoDos.JavaBackendProject.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.grupoDos.JavaBackendProject.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class JavaBackendProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaBackendProjectApplication.class, args);

		RestaurantRepository repoRestaurant = context.getBean(RestaurantRepository.class);
		UserRepository repoUser = context.getBean(UserRepository.class);
		CustomerRepository repoCustomer = context.getBean(CustomerRepository.class);
		MenuItemRepository repoMenu = context.getBean(MenuItemRepository.class);

		// Crear restaurantes, si no existen:
		Optional<Restaurant> optRestaurant = repoRestaurant.findById(1L);
		if (optRestaurant.isEmpty()) {
			Restaurant restaurant1 = new Restaurant
					(null, "Piamonte", "piamonte@email.com", 999555111, "Calle Mar 21", "Bilbao", 12380, "www.piamonte.com", "logoRestaurant-01.png");
			Restaurant restaurant2 = new Restaurant
					(null, "Napoli", "napoli@email.com", 888777444, "Calle Bota 11", "Barcelona", 89562, "www.napoli.com", "logoRestaurant-02.png");
			Restaurant restaurant3 = new Restaurant
					(null, "Roma", "roma@email.com", 111222333, "Calle Clavo 56", "Valencia", 23457, "www.roma.com", "logoRestaurant-03.png");
			Restaurant restaurant4 = new Restaurant
					(null, "Trapela", "trapela@email.com", 85462137, "Calle Fura 56", "Madrid", 85236, "www.trapela.com", "logoRestaurant-04.png");
			Restaurant restaurant5 = new Restaurant
					(null, "Mug", "mug@email.com", 888546234, "Calle Isla 56", "Sevilla", 96541, "www.mug.com", "logoRestaurant-05.png");
			Restaurant restaurant6 = new Restaurant
					(null, "Calzone", "calzone@email.com", 897654321, "Calle Isla 56", "Sevilla", 96541, "www.calzone.com", "logoRestaurant-06.png");

			//SAVE RESTAURANTS
			repoRestaurant.save(restaurant1);
			repoRestaurant.save(restaurant2);
			repoRestaurant.save(restaurant3);
			repoRestaurant.save(restaurant4);
			repoRestaurant.save(restaurant5);
			repoRestaurant.save(restaurant6);
		}

		// Create user, if not exists
		Optional<User> opt = repoUser.findById(1L);
		if (opt.isEmpty()) {
			User user = new User(null, "user", passwordEncoder().encode("1234"));
			User user2 = new User(null, "admin", passwordEncoder().encode("1234"));
			repoUser.save(user);
			repoUser.save(user2);
		}

		// Create customer, if not exists
		Optional<Customer> opt2 = repoCustomer.findById(1L);
		if (opt2.isEmpty()) {
			Customer customer = new Customer(
					null,
					"Cliente Ejemplo",
					"cliente@ejemplo.com",
					"$2a$12$NwQxWcefdbYvrKLrrPNzfudGfRgMdOjRtfssOZMBwTeJO9kS0hfXO",
					"111222333",
					"Calle Tal 3,5",
					"Ciudad",
					"00000"
			);

			repoCustomer.save(customer);
		}

		// Create menuItems, if they don't exist
		Optional<MenuItem> optMenuItem = repoMenu.findById(1L);
		if (optMenuItem.isEmpty()) {

			Restaurant restaurant = repoRestaurant.findById(1L).get();

			MenuItem ensaladaCaprese = new MenuItem( null, "Ensalada Caprese", "Tomates, mozzarella fresca y albahaca", 10.99, "Entrantes ", restaurant);
			MenuItem bruschetta = new MenuItem(null, "Bruschetta de tomate y albahaca", "Rebanadas de pan tostado, tomates, ajo y albahaca", 8.99, "Entrantes  ", restaurant);
			MenuItem arancini = new MenuItem(null, "Arancini de risotto", "Bolitas de risotto rellenas de queso mozzarella y fritas", 12.99, "Entrantes  ", restaurant);
			MenuItem minestrone = new MenuItem(null, "Minestrone", "Sopa de verduras con pasta y frijoles", 9.99, "Entrantes  ", restaurant);
			MenuItem parmigiana = new MenuItem(null, "Parmigiana di melanzane", "Berenjenas fritas con salsa de tomate, mozzarella y parmesano", 16.99, "Platos principales  ", restaurant);
			// Otros ejemplos de platos principales:
			MenuItem pizzaMargherita = new MenuItem(null, "Pizza Margherita", "Mozzarella, tomate y albahaca", 14.99, "Platos principales  ", restaurant);
			MenuItem lasagna = new MenuItem(null, "Lasagna alla bolognese", "Lasagna con carne picada, salsa boloñesa y queso parmesano", 18.99, "Platos principales  ", restaurant);
			MenuItem spaghettiCarbonara = new MenuItem(null, "Spaghetti alla carbonara", "Spaghetti con huevo, panceta, queso pecorino y pimienta negra", 17.99, "Platos principales  ", restaurant);
			MenuItem ravioli = new MenuItem(null, "Ravioli di ricotta e spinaci", "Ravioli rellenos de ricotta y espinacas con salsa de tomate", 20.99, "Platos principales  ", restaurant);
			MenuItem risotto = new MenuItem(null, "Risotto ai funghi", "Risotto con champiñones, queso parmesano y vino blanco", 19.99, "Platos principales  ", restaurant);
			MenuItem tiramisu = new MenuItem(null, "Tiramisú", "Bizcochos de soletilla empapados en café, crema de mascarpone y cacao en polvo", 8.99, "Postres  ", restaurant);
			MenuItem pannaCotta = new MenuItem(null, "Panna cotta", "Flan de nata con coulis de frutos rojos", 7.99, "Postres  ", restaurant);
			MenuItem cannoli = new MenuItem(null, "Cannoli", "Tubos de masa frita rellenos de ricotta y decorados con frutas confitadas", 9.99, "Postres  ", restaurant);
			MenuItem gelato = new MenuItem(null, "Gelato", "Helado italiano de varios sabores", 6.99, "Postres  ", restaurant);
			MenuItem affogato = new MenuItem(null, "Affogato al caffè", "Helado de vainilla con un expreso caliente", 7.99, "Postres  ", restaurant);

			repoMenu.save(ensaladaCaprese);
			repoMenu.save(bruschetta);
			repoMenu.save(arancini);
			repoMenu.save(minestrone);
			repoMenu.save(parmigiana);
			repoMenu.save(pizzaMargherita);
			repoMenu.save(lasagna);
			repoMenu.save(spaghettiCarbonara);
			repoMenu.save(ravioli);
			repoMenu.save(risotto);
			repoMenu.save(tiramisu);
			repoMenu.save(pannaCotta);
			repoMenu.save(cannoli);
			repoMenu.save(gelato);
			repoMenu.save(affogato);
		}

		System.out.println("\nI am ready to serve!");
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
