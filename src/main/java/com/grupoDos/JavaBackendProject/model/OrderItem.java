package com.grupoDos.JavaBackendProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String comments;
    private Float price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "menuitem_id")
    private MenuItem menuItem;

    // Constructors
    public OrderItem() {
    }

    public OrderItem(Long id, Order order, MenuItem menuItem, Integer quantity, String comments, Float price) {
        this.id = id;
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.comments = comments;
        this.price = price;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    // Derived attribute
    public Float getSubtotalPrice() {
        float subTotal = this.price * this.quantity;
        return subTotal;
    }
}
