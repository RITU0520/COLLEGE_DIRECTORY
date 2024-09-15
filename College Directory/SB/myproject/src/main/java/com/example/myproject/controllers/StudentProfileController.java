package com.example.myproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-profiles")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    @Autowired
    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @GetMapping
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileService.getAllStudentProfiles();
    }

    @GetMapping("/{user_id}")
    public StudentProfile getStudentProfileById(@PathVariable Integer user_id) {
        return studentProfileService.getStudentProfileById(user_id);
    }

    @PostMapping
    public StudentProfile createStudentProfile(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.createStudentProfile(studentProfile);
    }

    @PutMapping("/{user_id}")
    public StudentProfile updateStudentProfile(@PathVariable Integer user_id, @RequestBody StudentProfile studentProfile) {
        return studentProfileService.updateStudentProfile(user_id, studentProfile);
    }

    @DeleteMapping("/{user_id}")
    public void deleteStudentProfile(@PathVariable Integer user_id) {
        studentProfileService.deleteStudentProfile(user_id);
    }
}
