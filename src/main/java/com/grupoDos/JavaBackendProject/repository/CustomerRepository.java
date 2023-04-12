package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
}
