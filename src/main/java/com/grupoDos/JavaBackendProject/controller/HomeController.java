package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/inicio")
    public String inicio(Model model) {
        try {
            return "home";
        } catch (Exception e) {
            return "Algo no ha ido bien...";
        }
    }
}
