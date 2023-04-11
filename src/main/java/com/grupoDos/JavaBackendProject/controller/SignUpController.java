package com.grupoDos.JavaBackendProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.grupoDos.JavaBackendProject.model.Cliente;
import com.grupoDos.JavaBackendProject.service.GenericService;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class SignUpController {

   // @GetMapping("/signup")
   // String signup() {
   //     return "signup";
   // }

    @Autowired   //busca un bean, componente que implementa la interfaz y lo inyecta al atributo
  private GenericService<Cliente> ClienteService;

    @RequestMapping(value="/signup")
  public String crear(Map<String, Object> model) {
	  Cliente cliente = new Cliente();
	  model.put("cliente", cliente);
	 // model.put("titulo", "Formulario de cliente");
	  return "signup";
  }
 
   @RequestMapping(value="/signup", method=RequestMethod.POST)
	  public String guardar(Cliente cliente) {
	  try {
		ClienteService.saveOne(cliente);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  return "redirect:/";
	  } 
	
	
}

