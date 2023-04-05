package com.grupoDos.JavaBackendProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orderitem")
public class OrderItem {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long menuItemId;
    private Integer quantity;
    private String comments;
    private Float price;

    // Constructors
    public OrderItem() {
    }

    public OrderItem(Long id, Long orderId, Long menuItemId, Integer quantity, String comments, Float price) {
        this.id = id;
        this.orderId = orderId;
        this.menuItemId = menuItemId;
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
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
