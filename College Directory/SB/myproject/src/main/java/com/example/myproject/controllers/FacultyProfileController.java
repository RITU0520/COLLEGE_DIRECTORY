package com.example.myproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty-profiles")
public class FacultyProfileController {

    private final FacultyProfileService facultyProfileService;

    @Autowired
    public FacultyProfileController(FacultyProfileService facultyProfileService) {
        this.facultyProfileService = facultyProfileService;
    }

    @GetMapping
    public List<FacultyProfile> getAllFacultyProfiles() {
        return facultyProfileService.getAllFacultyProfiles();
    }

    @GetMapping("/{user_id}")
    public FacultyProfile getFacultyProfileById(@PathVariable Integer user_id) {
        return 
        facultyProfileService.getFacultyProfileById(user_id);
    }

    @PostMapping
    public FacultyProfile createFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        return facultyProfileService.createFacultyProfile(facultyProfile);
    }

    @PutMapping("/{user_id}")
    public FacultyProfile updateFacultyProfile(@PathVariable Integer user_id, @RequestBody FacultyProfile facultyProfile) {
        return facultyProfileService.updateFacultyProfile(user_id, facultyProfile);
    }

    @DeleteMapping("/{user_id}")
    public void deleteFacultyProfile(@PathVariable Integer user_id) {
        facultyProfileService.deleteFacultyProfile(user_id);
    }
}

