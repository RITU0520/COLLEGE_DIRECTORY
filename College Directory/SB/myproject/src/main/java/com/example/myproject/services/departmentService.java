package com.example.myproject.services;

import com.example.myproject.entities.department;
import com.example.myproject.repositories.departmentRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class departmentService {

    private final departmentRepositories departmentRepositories;

    public departmentService(departmentRepositories departmentRepositories) {
        this.departmentRepositories = departmentRepositories;
    }

    public List<department> getAlldepartments() {
        return departmentRepositories.findAll();
    }

    public Optional<department> getdepartmentById(Long id) {
        return departmentRepositories.findById(id);
    }

    public department createDepartment(department department) {
        return departmentRepositories.save(department);
    }

    public department updateDepartment(Long id, department departmentDetails) {
        return departmentRepositories.findById(id)
                .map(department -> {
                    department.setName(departmentDetails.getName());
                    department.setDescription(departmentDetails.getDescription());
                    return departmentRepositories.save(department);
                }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void deleteDepartment(Long id) {
        departmentRepositories.deleteById(id);
    }
}

