package com.grupoDos.JavaBackendProject.service;

import com.grupoDos.JavaBackendProject.model.Cliente;
import com.grupoDos.JavaBackendProject.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements GenericService<Cliente>{

    @Autowired
    private ClienteRepository repository;


    @Override
    @Transactional //Realiza un roll back si no se puede ejecutar
    public List<Cliente> findAll() throws Exception {
        try {
            List<Cliente> entities = this.repository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente findById(long id) throws Exception {
        try {
            Optional<Cliente> opt = this.repository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente saveOne(Cliente entity) throws Exception {
        try {
            Cliente Cliente = this.repository.save(entity);
            return Cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Cliente updateOne(Cliente entity, long id) throws Exception {
        try {
            Optional<Cliente> opt = this.repository.findById(id);
            Cliente Cliente = opt.get();
            Cliente= this.repository.save(entity);
            return Cliente;
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
