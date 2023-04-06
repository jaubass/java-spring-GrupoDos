package com.grupoDos.JavaBackendProject.model;

import jakarta.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "restaurantes")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{NotEmpty.Restautant.name}")
    private String name;
    private String email;
    private int phone;
    private String adress;
    private String city;
    private int postalCode;
    private String web;
    private String rutaImg;

    public Restaurant() {}

    public Restaurant(Long id, String name, String email, int phone, String adress, String city, int postalCode, String web) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.web = web;

    }

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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
