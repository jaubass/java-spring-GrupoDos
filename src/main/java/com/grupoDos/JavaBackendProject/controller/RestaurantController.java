package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.*;
import com.grupoDos.JavaBackendProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService svcRestaurant;

    @GetMapping("/restaurants")
    public String index(Model model) {
        try {
            List<Restaurant> restaurant = this.svcRestaurant.findAll();
            model.addAttribute("restaurant", restaurant);
            return "restaurants";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*
        // LISTA PRUEBA INTERFACE SIN PERSISTENCIA

        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(new Restaurant (null, "Piamonte", "piamonte@email.com", 999555111, "Calle Mar 21", "Bilbao", 12380, "www.piamonte.com"));
        restaurants.add(new Restaurant (null, "Napoli", "napoli@email.com", 888777444, "Calle Bota 11", "Barcelona", 23453, "www.napoli.com"));
        restaurants.add(new Restaurant (null, "Roma", "roma@email.com", 111222333, "Calle Clavo 56", "Alicante", 89726, "www.roma.com"));
        restaurants.add(new Restaurant (null, "Funghi", "funghi@email.com", 776655443, "Calle Champiñon 36", "Madrid", 34567, "www.funghi.com"));
        restaurants.add(new Restaurant (null, "Pizzeria Arreo", "adapada@email.com", 654987321, "Calle Kadabra 66", "Sevilla", 34567, "www.arreo.com"));

        model.addAttribute("restaurant", restaurants);

        return "restaurants.html";
        */

    }
}
