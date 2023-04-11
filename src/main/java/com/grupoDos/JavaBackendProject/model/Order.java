package com.grupoDos.JavaBackendProject.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private LocalDateTime dateTime;
    private String status;

    // Constructors
    public Order() {
    }

    public Order(Long id, Long customerId, LocalDateTime dateTime, String status) {
        this.id = id;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.status = status;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Derived attribute
    public float totalPrice() {
        float total = 0f;
        // TODO



        return total;
    }
}

