package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
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
    }
}
