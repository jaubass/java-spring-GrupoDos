package com.grupoDos.JavaBackendProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HelloController {

        @GetMapping("/")
        public String saludo () {
            return "Hello World! with Spring Boot - by GrupoDos!";
        }
}
