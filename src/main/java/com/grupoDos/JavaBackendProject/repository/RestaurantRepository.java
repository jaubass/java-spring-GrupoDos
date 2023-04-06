package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository <Restaurant, Long>{
}
