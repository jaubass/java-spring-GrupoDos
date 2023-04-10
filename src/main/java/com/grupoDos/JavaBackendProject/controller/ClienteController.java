package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.Cliente;
import com.grupoDos.JavaBackendProject.utils.ClienteGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteGenerator clienteGenerator;

    @GetMapping("/clientes")
    public String mostrarClientes(Model model) {
        List<Cliente> clientes = clienteGenerator.generateClientes(10);
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

}

