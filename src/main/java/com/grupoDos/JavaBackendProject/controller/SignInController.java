package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SignInController {

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@RequestBody Customer userData) {
        System.out.println("I am receiving a post request!");
        // TODO: get data from body and check the login from Database
        System.out.println(userData);
        return "redirect:/user/profile";
    }

}

