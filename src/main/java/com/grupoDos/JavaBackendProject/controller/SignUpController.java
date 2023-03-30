package com.grupoDos.JavaBackendProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    String signup() {
        return "signup";
    }
}

