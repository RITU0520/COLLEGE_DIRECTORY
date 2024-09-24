package com.example.myproject.services;

import com.example.myproject.entities.faculty;
import com.example.myproject.repositories.facultyRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class facultyService {

    private final facultyRepositories facultyRepositories;

    public facultyService(facultyRepositories facultyRepositories) {
        this.facultyRepositories = facultyRepositories;
    }

    public List<faculty> getAllFaculties() {
        return facultyRepositories.findAll();
    }

    public Optional<faculty> getFacultyProfileById(Long id) {
        return facultyRepositories.findById(id);
    }

    public faculty createFacultyProfile(faculty faculty) {
        return facultyRepositories.save(faculty);
    }

    public faculty updateFaculty(Long id, faculty profileDetails) {
        return facultyRepositories.findById(id)
                .map(profile -> {
                    profile.setPhoto(profileDetails.getPhoto());
                    profile.setOfficeHours(profileDetails.getOfficeHours());
                    profile.setDepartment(profileDetails.getDepartment());
                    return facultyRepositories.save(profile);
                }).orElseThrow(() -> new RuntimeException("Faculty profile not found"));
    }

    public void deleteFacultyProfile(Long id) {
        facultyRepositories.deleteById(id);
    }
}
