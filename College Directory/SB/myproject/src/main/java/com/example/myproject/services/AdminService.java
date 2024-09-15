package com.example.myproject.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Get a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    // Update a user
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            // Update other fields as needed
            return userRepository.save(existingUser);
        }
        return null;
    }
    
    // Delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    // Create a new role
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    
    // Get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    
    // Get a role by ID
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
    
    // Update a role
    public Role updateRole(Long id, Role role) {
        Role existingRole = getRoleById(id);
        if (existingRole != null) {
            existingRole.setName(role.getName());
            // Update other fields as needed
            return roleRepository.save(existingRole);
        }
        return null;
    }
    
    // Delete a role
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}

