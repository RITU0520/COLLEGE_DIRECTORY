package com.example.myproject.services;

import com.example.myproject.entities.enrollment;
import com.example.myproject.repositories.enrollmentRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class enrollmentService {

    private final enrollmentRepositories enrollmentRepositories;

    public enrollmentService(enrollmentRepositories enrollmentRepositories) {
        this.enrollmentRepositories = enrollmentRepositories;
    }

    public List<enrollment> getAllEnrollments() {
        return enrollmentRepositories.findAll();
    }

    public Optional<enrollment> getEnrollmentById(Long id) {
        return enrollmentRepositories.findById(id);
    }

    public enrollment createEnrollment(enrollment enrollment) {
        return enrollmentRepositories.save(enrollment);
    }

    public enrollment updateEnrollment(Long id, enrollment enrollmentDetails) {
        return enrollmentRepositories.findById(id)
                .map(enrollment -> {
                    enrollment.setCourse(enrollmentDetails.getCourse());
                    enrollment.setStudent(enrollmentDetails.getStudent());
                    return enrollmentRepositories.save(enrollment);
                }).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepositories.deleteById(id);
    }
}
