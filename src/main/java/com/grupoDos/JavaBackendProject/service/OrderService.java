package com.grupoDos.JavaBackendProject.service;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.model.Order;
import com.grupoDos.JavaBackendProject.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements GenericService<Order> {

    @Autowired
    private OrderRepository repository;


    @Override
    @Transactional //Realiza un roll back si no se puede ejecutar
    public List<Order> findAll() throws Exception {
        try {
            List<Order> entities = this.repository.findAll();
            System.out.println(entities);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order findById(long id) throws Exception {
        try {
            Optional<Order> opt = this.repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Customer findOneByEmail(String email) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public Order saveOne(Order entity) throws Exception {
        try {
            Order order = this.repository.save(entity);
            return order;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Order updateOne(Order entity, long id) throws Exception {
        try {
            Optional<Order> opt = this.repository.findById(id);
            Order order = opt.get();
            order= this.repository.save(entity);
            return order;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    //TO DO
    public boolean deleteById(long id) throws Exception {
        return false;
    }



}
