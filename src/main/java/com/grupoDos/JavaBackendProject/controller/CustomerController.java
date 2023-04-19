package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService svcCustomer;

    @GetMapping("/profile")
    public String index(Model model) throws Exception {
        try {
            Customer customer = this.svcCustomer.findById(1L);
            model.addAttribute("customer", customer);
            return "profile";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/customers/add")
    public String addCustomer(@RequestBody Customer customerData, Model model)
            throws Exception {
        // TODO: Comprobar que los datos sean correctos
        Customer newCustomer = svcCustomer.saveOne(customerData);
        model.addAttribute("customer", newCustomer);
        return "customer_added";
    }

    @GetMapping("/customers/{id}")
    public String getCustomer(@PathVariable Long id, Model model)
            throws Exception {
        Customer customer = this.svcCustomer.findById(id);
        model.addAttribute("customer", customer);
        return "profile";
    }

    @PutMapping("/customers/{id}")
    public String updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customerData,
            Model model
    ) throws Exception {
        Customer newCustomer = svcCustomer.saveOne(customerData);
        model.addAttribute("customer", newCustomer);
        return "customer_added";
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id, Model model)
        throws Exception {
        Customer customer = this.svcCustomer.findById(id);
        boolean deletedOk = this.svcCustomer.deleteById(id);
        model.addAttribute("customer", customer);
        return "customer_added";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/hello-admin-user")
    public String adminUser(){
        return "Only Admins and Users Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello-user")
    public String userPing(){
        return "Any User Can Read This";
    }

}
