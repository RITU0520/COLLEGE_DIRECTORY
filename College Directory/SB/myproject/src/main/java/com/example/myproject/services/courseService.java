package com.example.myproject.services;

import com.example.myproject.entities.course;
import com.example.myproject.repositories.courseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class courseService {

    private final courseRepository courseRepository;

    public courseService(courseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public course createCourse(course course) {
        return courseRepository.save(course);
    }

    public course updateCourse(Long id, course courseDetails) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setTitle(courseDetails.getTitle());
                    course.setDescription(courseDetails.getDescription());
                    course.setDepartment(courseDetails.getDepartment());
                    course.setFacultyMember(courseDetails.getFacultyMember());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
