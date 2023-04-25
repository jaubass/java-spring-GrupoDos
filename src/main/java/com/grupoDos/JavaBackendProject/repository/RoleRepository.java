package com.grupoDos.JavaBackendProject.repository;

import com.grupoDos.JavaBackendProject.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name); // buscar un rol por nombre

    List<Role> findByDescriptionContaining(String keyword); // buscar roles por descripción que contengan una palabra clave

    List<Role> findByOrderByDescriptionAsc(); // buscar todos los roles ordenados por descripción de forma ascendente

    List<Role> findByOrderByDescriptionDesc(); // buscar todos los roles ordenados por descripción de forma descendente

}
