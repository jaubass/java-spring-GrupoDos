package com.grupoDos.JavaBackendProject.service;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService implements GenericService<Restaurant>{

    @Autowired
    private RestaurantRepository repository;


    @Override
    @Transactional //Realiza un roll back si no se puede ejecutar
    public List<Restaurant> findAll() throws Exception {
        try {
            List<Restaurant> entities = this.repository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Restaurant findById(long id) throws Exception {
        try {
            Optional<Restaurant> opt = this.repository.findById(id);
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
    public Restaurant saveOne(Restaurant entity) throws Exception {
        try {
            Restaurant restaurant = this.repository.save(entity);
            return restaurant;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Restaurant updateOne(Restaurant entity, long id) throws Exception {
        try {
            Optional<Restaurant> opt = this.repository.findById(id);
            Restaurant restaurant = opt.get();
            restaurant= this.repository.save(entity);
            return restaurant;
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
