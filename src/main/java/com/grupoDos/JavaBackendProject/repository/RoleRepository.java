package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}