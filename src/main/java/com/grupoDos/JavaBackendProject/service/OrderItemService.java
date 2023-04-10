package com.grupoDos.JavaBackendProject.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.grupoDos.JavaBackendProject.model.OrderItem;
import com.grupoDos.JavaBackendProject.model.Restaurant;
import com.grupoDos.JavaBackendProject.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService implements GenericService<OrderItem> {

    @Autowired
    private OrderItemRepository repository;

    @Override
    @Transactional
    public List<OrderItem> findAll() throws Exception {
        try {
            List<OrderItem> entities = this.repository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem findById(long id) throws Exception {
        try {
            Optional<OrderItem> opt = this.repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem saveOne(OrderItem entity) throws Exception {
        try {
            OrderItem orderItem = this.repository.save(entity);
            return orderItem;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public OrderItem updateOne(OrderItem entity, long id) throws Exception {
        try {
            Optional<OrderItem> opt = this.repository.findById(id);
            OrderItem orderItem = opt.get();
            orderItem= this.repository.save(entity);
            return orderItem;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteById(long id) throws Exception {
        try {
            Optional<OrderItem> opt = this.repository.findById(id);
            this.repository.deleteById(opt.get().getId());
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
