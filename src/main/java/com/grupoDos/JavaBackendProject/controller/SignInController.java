package com.grupoDos.JavaBackendProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    @GetMapping("/signin")
    String signin() {
        return "signin";
    }

    @PostMapping("/signin")
    String login() {
        // TODO: get data from body and check the login from Database
        return "redirect:/profile";
    }

}

