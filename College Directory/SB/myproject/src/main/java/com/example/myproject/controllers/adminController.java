package com.example.myproject.controllers;

import com.example.myproject.entities.admin;
import com.example.myproject.services.adminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrator-profiles")
public class adminController {

    private final adminService adminService;

    public adminController(adminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<admin> getAlladmin() {
        return adminService.getAlladmin();
    }

    @GetMapping("/{id}")
    public ResponseEntity<admin> getAdministratorProfileById(@PathVariable Long id) {
        return adminService.getadminiById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public admin createAdministratorProfile(@RequestBody admin admin) {
        return adminService.createAdministratorProfile(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<admin> updateAdministratorProfile(@PathVariable Long id, @RequestBody admin profileDetails) {
        return adminService.updateAdministratorProfile(id, profileDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministratorProfile(@PathVariable Long id) {
        adminService.deleteAdministratorProfile(id);
        return ResponseEntity.noContent().build();
    }
}
