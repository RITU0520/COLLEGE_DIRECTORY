package com.example.myproject.entities;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private department department;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private faculty facultyMember;

    @OneToMany(mappedBy = "course")
    private Set<enrollment> enrollments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public department getDepartment() {
        return department;
    }

    public void setDepartment(department department) {
        this.department = department;
    }

    public faculty getFacultyMember() {
        return facultyMember;
    }

    public void setFacultyMember(faculty facultyMember) {
        this.facultyMember = facultyMember;
    }

    public Set<enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    // Getters and setters
}
