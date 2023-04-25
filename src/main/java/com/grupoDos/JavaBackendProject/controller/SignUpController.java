package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grupoDos.JavaBackendProject.service.GenericService;

import java.util.Map;

@Controller
public class SignUpController {

   @GetMapping("/signup")
   String signup() {
       return "signup";
   }
/*
    @Autowired   //busca un bean, componente que implementa la interfaz y lo inyecta al atributo
  private GenericService<Customer> CustomerService;

    @RequestMapping(value="/signup")
  public String crear(Map<String, Object> model) {
	  //Customer customer = new Customer();
	  //model.put("customer", customer);
	 // model.put("titulo", "Formulario de cliente");
	  return "signup";
  }

   @RequestMapping(value="/signup", method=RequestMethod.POST)
	  public String guardar(Customer customer) {
	  try {
		CustomerService.saveOne(customer);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  return "redirect:/";
	  }
	*/

}

