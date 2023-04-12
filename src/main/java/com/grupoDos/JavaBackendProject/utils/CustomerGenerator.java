package com.grupoDos.JavaBackendProject.utils;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerGenerator {

    private final Faker faker;

    public CustomerGenerator(Faker faker) {
        this.faker = faker;
    }

    public List<Customer> generateCustomers(int numCustomers) {
        List<Customer> Customers = new ArrayList<>();
        for (int i = 0; i < numCustomers; i++) {
            Customer Customer = new Customer();
            Customer.setName(faker.name().fullName());
            Customer.setEmail(faker.internet().emailAddress());
            Customer.setPassword(faker.internet().password());
            Customer.setTelf(faker.phoneNumber().toString());
            Customer.setAddress(faker.address().fullAddress());
            Customer.setCity(faker.address().city());
            Customer.setPostalCode(faker.address().zipCode());
            Customers.add(Customer);
        }
        return Customers;
    }
}

