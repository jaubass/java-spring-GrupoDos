package com.grupoDos.JavaBackendProject.controller;


import com.grupoDos.JavaBackendProject.model.Order;
import com.grupoDos.JavaBackendProject.model.OrderItem;
import com.grupoDos.JavaBackendProject.service.OrderItemService;
import com.grupoDos.JavaBackendProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {

    @Autowired private OrderService svcOrder;
    @Autowired private OrderItemService svcMenu;

    @GetMapping("/orders")
    public String index(Model model) {
        try {
            List<Order> orders = this.svcOrder.findAll();
            model.addAttribute("orders", orders);
            return "orders";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        try {
            List<OrderItem> menu = this.svcMenu.findAll();
            model.addAttribute("menu", menu);
            return "cart";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
