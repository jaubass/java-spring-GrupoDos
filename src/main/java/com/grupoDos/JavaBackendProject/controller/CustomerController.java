package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService svcCustomer;

    @GetMapping("/customer")
    public String index(Model model) throws Exception {
        try {
            Customer customer = this.svcCustomer.findById(1L);
            model.addAttribute("customer", customer);
            return "customer";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
