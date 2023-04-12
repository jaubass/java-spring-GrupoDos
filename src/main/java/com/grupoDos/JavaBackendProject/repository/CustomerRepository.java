package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{
}
