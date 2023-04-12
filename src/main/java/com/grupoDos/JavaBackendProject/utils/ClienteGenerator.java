package com.grupoDos.JavaBackendProject.utils;

import com.grupoDos.JavaBackendProject.model.Cliente;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteGenerator {

    private final Faker faker;

    public ClienteGenerator(Faker faker) {
        this.faker = faker;
    }

    public List<Cliente> generateClientes(int numClientes) {
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente = new Cliente();
            cliente.setName(faker.name().fullName());
            cliente.setEmail(faker.internet().emailAddress());
            cliente.setPassword(faker.internet().password());
            cliente.setTelf(faker.number().numberBetween(100000000, 999999999));
            cliente.setAddress(faker.address().fullAddress());
            cliente.setCity(faker.address().city());
            cliente.setPostalCode(faker.number().numberBetween(10000, 99999));
            clientes.add(cliente);
        }
        return clientes;
    }
}

