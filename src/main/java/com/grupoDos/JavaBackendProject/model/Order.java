package com.grupoDos.JavaBackendProject.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "order")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private LocalDateTime dateTime;
    private String status;
    private Float totalPrice;
    
    // Constructor
    public Order(Long id, Long customerId, LocalDateTime dateTime, String status, Float totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.dateTime = dateTime;
        this.status = status;
        this.totalPrice = totalPrice;
    }
    
    // Getters and Setters
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
    
    public Float getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
