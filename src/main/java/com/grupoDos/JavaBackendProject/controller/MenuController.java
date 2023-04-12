package com.grupoDos.JavaBackendProject.controller;

import com.grupoDos.JavaBackendProject.model.MenuItem;
import com.grupoDos.JavaBackendProject.model.OrderItem;
import com.grupoDos.JavaBackendProject.service.MenuItemService;
import com.grupoDos.JavaBackendProject.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired private MenuItemService svcMenu;
    @Autowired private OrderItemService svcItems;

    @GetMapping("/menu")
    public String index(Model model) {
        try {
            List<MenuItem> menu = this.svcMenu.findAll();
            model.addAttribute("menu", menu);
            return "menu";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add")
    public String addItem(@RequestBody OrderItem item) throws Exception {
        System.out.println(item);
        svcItems.saveOne(item);
        return "redirect:/cart";
    }
}
