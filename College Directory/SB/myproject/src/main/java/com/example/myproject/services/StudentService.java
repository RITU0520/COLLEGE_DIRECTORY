package com.example.myproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.myproject.entities.student;
import com.example.myproject.repositories.studentRepositories;

@Service
public class StudentService {

    private final studentRepositories studentRepositories;

    public StudentService(studentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;

    public List<student> getAllStudentProfiles() {
        return studentRepositories.findAll();
    }

    public Optional<student> getStudentProfileById(Long id) {
        return studentRepositories.findById(id);
    }

    public student createStudentProfile(student studentProfile) {
        return studentRepositories.save(studentProfile);
    }

    public studentRepositories updateStudentProfile(Long id, student profileDetails) {
        return (com.example.myproject.repositories.studentRepositories) studentRepositories.findById(id)
                .map(profile -> {
                    profile.setPhoto(profileDetails.getPhoto());
                    profile.setYear(profileDetails.getYear());
                    profile.setDepartment(profileDetails.getDepartment());
                    return studentRepositories.save(profile);
                }).orElseThrow(() -> new RuntimeException("Student profile not found"));
    }

    public void deleteStudentProfile(Long id) {
        studentRepositories.deleteById(id);
    }
}

