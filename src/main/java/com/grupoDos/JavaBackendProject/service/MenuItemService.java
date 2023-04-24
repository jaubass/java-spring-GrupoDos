package com.grupoDos.JavaBackendProject.service;

import com.grupoDos.JavaBackendProject.model.Customer;
import com.grupoDos.JavaBackendProject.model.MenuItem;
import com.grupoDos.JavaBackendProject.model.OrderItem;
import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.repository.MenuItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService implements GenericService<MenuItem> {

    @Autowired private MenuItemRepository repository;

    @Override
    @Transactional //Realiza un roll back si no se puede ejecutar
    public List<MenuItem> findAll() throws Exception {
        try {
            List<MenuItem> entities = this.repository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public MenuItem findById(long id) throws Exception {
        try {
            Optional<MenuItem> opt = this.repository.findById(id);
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
    public MenuItem saveOne(MenuItem entity) throws Exception {
        try {
            MenuItem menuItem = this.repository.save(entity);
            return menuItem;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public MenuItem updateOne(MenuItem entity, long id) throws Exception {
        try {
            Optional<MenuItem> opt = this.repository.findById(id);
            MenuItem menuItem = opt.get();
            menuItem= this.repository.save(entity);
            return menuItem;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<MenuItem> opt = this.repository.findById(id);
            this.repository.deleteById(opt.get().getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
