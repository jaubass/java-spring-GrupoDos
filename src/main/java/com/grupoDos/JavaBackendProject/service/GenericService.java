package com.grupoDos.JavaBackendProject.service;

import com.grupoDos.JavaBackendProject.model.Customer;
import jakarta.transaction.Transactional;

import java.util.List;

public interface GenericService<E> {

    List<E> findAll() throws Exception;
    E findById(long id) throws Exception;

    @Transactional
    Customer findOneByEmail(String email) throws Exception;

    E saveOne(E entity) throws Exception;
    E updateOne(E entity, long id) throws Exception;
    boolean deleteById(long id) throws Exception;
}
