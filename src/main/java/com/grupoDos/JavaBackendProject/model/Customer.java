package com.grupoDos.JavaBackendProject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String telf;
    private String address;
    private String city;
    private String postalCode;

    // Constructors

    public Customer() {
    }

    public Customer(Long id, String name, String email, String password, String telf, String address, String city, String postalCode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telf = telf;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
