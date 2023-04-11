package com.grupoDos.JavaBackendProject;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.model.MenuItem;
import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.repository.CustomerRepository;
import com.grupoDos.JavaBackendProject.repository.MenuItemRepository;
import com.grupoDos.JavaBackendProject.repository.RestaurantRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.grupoDos.JavaBackendProject.repository.ClienteRepository;

@SpringBootApplication
public class JavaBackendProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaBackendProjectApplication.class, args);
		RestaurantRepository repository = context.getBean(RestaurantRepository.class);
		CustomerRepository repoCustomer = context.getBean(CustomerRepository.class);
		MenuItemRepository repoMenu = context.getBean(MenuItemRepository.class);

		//Get customers
		ClienteRepository repository2 = context.getBean(ClienteRepository.class);

		//CREATE RESTAURANTS
		/*
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

		// Create menuItems
		Optional<MenuItem> optMenuItem = repoMenu.findById(1L);
		if (optMenuItem.isEmpty()) {

		MenuItem ensaladaCaprese = new MenuItem( null, 1L, "Ensalada Caprese", "Tomates, mozzarella fresca y albahaca", 10.99, "Entrantes");
		MenuItem bruschetta = new MenuItem(null, 1L, "Bruschetta de tomate y albahaca", "Rebanadas de pan tostado, tomates, ajo y albahaca", 8.99, "Entrantes");
		MenuItem arancini = new MenuItem(null, 1L, "Arancini de risotto", "Bolitas de risotto rellenas de queso mozzarella y fritas", 12.99, "Entrantes");
		MenuItem minestrone = new MenuItem(null, 1L, "Minestrone", "Sopa de verduras con pasta y frijoles", 9.99, "Entrantes");
		MenuItem parmigiana = new MenuItem(null, 1L, "Parmigiana di melanzane", "Berenjenas fritas con salsa de tomate, mozzarella y parmesano", 16.99, "Platos principales");
		// Otros ejemplos de platos principales:
		MenuItem pizzaMargherita = new MenuItem(null, 1L, "Pizza Margherita", "Mozzarella, tomate y albahaca", 14.99, "Platos principales");
		MenuItem lasagna = new MenuItem(null, 1L, "Lasagna alla bolognese", "Lasagna con carne picada, salsa boloñesa y queso parmesano", 18.99, "Platos principales");
		MenuItem spaghettiCarbonara = new MenuItem(null, 1L, "Spaghetti alla carbonara", "Spaghetti con huevo, panceta, queso pecorino y pimienta negra", 17.99, "Platos principales");
		MenuItem ravioli = new MenuItem(null, 1L, "Ravioli di ricotta e spinaci", "Ravioli rellenos de ricotta y espinacas con salsa de tomate", 20.99, "Platos principales");
		MenuItem risotto = new MenuItem(null, 1L, "Risotto ai funghi", "Risotto con champiñones, queso parmesano y vino blanco", 19.99, "Platos principales");
		MenuItem tiramisu = new MenuItem(null, 1L, "Tiramisú", "Bizcochos de soletilla empapados en café, crema de mascarpone y cacao en polvo", 8.99, "Postres");
		MenuItem pannaCotta = new MenuItem(null, 1L, "Panna cotta", "Flan de nata con coulis de frutos rojos", 7.99, "Postres");
		MenuItem cannoli = new MenuItem(null, 1L, "Cannoli", "Tubos de masa frita rellenos de ricotta y decorados con frutas confitadas", 9.99, "Postres");
		MenuItem gelato = new MenuItem(null, 1L, "Gelato", "Helado italiano de varios sabores", 6.99, "Postres");
		MenuItem affogato = new MenuItem(null, 1L, "Affogato al caffè", "Helado de vainilla con un expreso caliente", 7.99, "Postres");

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
		//RETRIEVE RESTAURANTS
		System.out.println(repository.findAll().size());

		//RETRIEVE CUSTOMERS
		System.out.println(repository2.findAll().size());

	}
}
