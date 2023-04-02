package com.grupoDos.JavaBackendProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signin")
    String signup() {
        return "signin";
    }

}

