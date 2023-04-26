package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

    Optional<UserDetails> findOneByEmail(String email);
}
