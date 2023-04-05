package com.grupoDos.JavaBackendProject.service;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.model.OrderItem;
import com.grupoDos.JavaBackendProject.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements GenericService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Override
    @Transactional
    public List<Customer> findAll() throws Exception {
        try {
            List<Customer> entities = this.repository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Customer findById(long id) throws Exception {
        try {
            Optional<Customer> opt = this.repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Customer saveOne(Customer entity) throws Exception {
        try {
            Customer customer = this.repository.save(entity);
            return customer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Customer updateOne(Customer entity, long id) throws Exception {
        try {
            Optional<Customer> opt = this.repository.findById(id);
            Customer customer = opt.get();
            customer= this.repository.save(entity);
            return customer;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<Customer> opt = this.repository.findById(id);
            this.repository.deleteById(opt.get().getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
