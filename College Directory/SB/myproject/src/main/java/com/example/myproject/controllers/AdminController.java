package com.example.myproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrator-profiles")
public class AdminController {

    private final AdminService administratorProfileService;

    @Autowired
    public AdminController(AdministratorProfileService administratorProfileService) {
        this.administratorProfileService = administratorProfileService;
    }

    @GetMapping
    public List<AdministratorProfile> getAllAdministratorProfiles() {
        return AdminContrllerService.getAllAdministratorProfiles();
    }

    @GetMapping("/{user_id}")
    public AdminController getAdministratorProfileById(@PathVariable Integer user_id) {
        return 
        administratorProfileService.getAdministratorProfileById(user_id);
    }

    @PostMapping
    public AdministratorProfile createAdministratorProfile(@RequestBody AdministratorProfile administratorProfile) {
        return administratorProfileService.createAdministratorProfile(administratorProfile);
    }

    @PutMapping("/{user_id}")
    public AdministratorProfile updateAdministratorProfile(@PathVariable Integer user_id, @RequestBody AdministratorProfile administratorProfile) {
        return administratorProfileService.updateAdministratorProfile(user_id, administratorProfile);
    }

    @DeleteMapping("/{user_id}")
    public void deleteAdministratorProfile(@PathVariable Integer user_id) {
        administratorProfileService.deleteAdministratorProfile(user_id);
    }
}

