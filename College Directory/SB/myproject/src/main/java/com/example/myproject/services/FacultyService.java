package com.example.myproject.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.repositories.FacultyRepository;

@Service
public class FacultyService {
    
    @Autowired
    private FacultyRepository facultyRepository;
    
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }
    
    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
    
    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty existingFaculty = getFacultyById(id);
        if (existingFaculty != null) {
            existingFaculty.setName(faculty.getName());
            existingFaculty.setDepartment(faculty.getDepartment());
            // Update other fields as needed
            return facultyRepository.save(existingFaculty);
        }
        return null;
    }
    
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}

