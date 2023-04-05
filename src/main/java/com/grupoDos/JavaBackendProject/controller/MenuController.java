package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.MenuItem;
import com.grupoDos.JavaBackendProject.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    @Autowired private MenuItemService svcMenuItem;

    @GetMapping("/menu")
    public String index(Model model) {
        try {
            List<MenuItem> menuItems = this.svcMenuItem.findAll();
            model.addAttribute("menuItems", menuItems);
            return "menu";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
