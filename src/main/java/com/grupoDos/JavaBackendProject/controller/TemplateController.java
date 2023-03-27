package com.grupoDos.JavaBackendProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    @GetMapping("/template")
    public String template () {
            return "templates/template";
        }

    @GetMapping("/")
    public String saludo () {
        return "home";
    }


}
