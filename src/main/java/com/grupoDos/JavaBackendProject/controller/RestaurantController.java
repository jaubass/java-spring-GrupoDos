package com.grupoDos.JavaBackendProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {

    @GetMapping("/restaurants")
    public String index(Model model) {
        return "restaurants.html";
    }
}
