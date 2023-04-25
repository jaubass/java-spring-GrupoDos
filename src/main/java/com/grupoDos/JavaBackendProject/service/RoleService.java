package com.grupoDos.JavaBackendProject.service;


import com.grupoDos.JavaBackendProject.model.Role;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }
    
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }
    
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
    
}
