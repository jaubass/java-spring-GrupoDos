package com.grupoDos.JavaBackendProject.service;


import com.grupoDos.JavaBackendProject.model.Role;

public interface RoleService {
    Role findByName(String name);
}
