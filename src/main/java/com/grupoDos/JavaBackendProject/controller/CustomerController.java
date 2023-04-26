package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService svcCustomer;

    @RequestMapping(value= {"/customers_list"}, method=RequestMethod.GET)
    public String listar(Model model) {
  	  model.addAttribute("titulo", "Listado de clientes");
  	  try {
		model.addAttribute("clientes", svcCustomer.findAll());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	  return "customers_list";
    }



    @GetMapping("/user")
    public String index(Model model) throws Exception {
        try {
            Customer customer = this.svcCustomer.findById(1L);
            Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
            model.addAttribute("auth", auth);
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

/*
    @GetMapping("/signup/{id}")
     public String getCustomer(@PathVariable Long id, Model model)
            throws Exception {
        Customer customer = this.svcCustomer.findById(id);
        model.addAttribute("customer", customer);
      // return "profile";
         return "signup";
    }

    @PutMapping("/signup/{id}")
    public String updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customerData,
            Model model
    ) throws Exception {
        Customer newCustomer = svcCustomer.saveOne(customerData);
        model.addAttribute("customer", newCustomer);
        return "customer_added";
    }
*/
	@RequestMapping(value="/eliminar/{id}")
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
