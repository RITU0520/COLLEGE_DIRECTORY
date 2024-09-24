package com.example.myproject.controllers;

import com.example.myproject.entities.department;
import com.example.myproject.services.departmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final departmentService departmentService;

    public DepartmentController(departmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<department> getAllDepartments() {
        return departmentService.getAlldepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<department> getDepartmentById(@PathVariable Long id) {
        return departmentService.getdepartmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public department createDepartment(@RequestBody department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public ResponseEntity<department> updateDepartment(@PathVariable Long id, @RequestBody department departmentDetails) {
        return departmentService.updateDepartment(id, departmentDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
