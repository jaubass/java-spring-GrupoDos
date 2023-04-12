package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
