package com.example.myproject.entities;


import java.util.Optional;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department")
    private Set<student> student;

    @OneToMany(mappedBy = "department")
    private Set<faculty> faculty;

    @OneToMany(mappedBy = "department")
    private Set<admin> admin;

    @OneToMany(mappedBy = "department")
    private Set<course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<student> getStudent() {
        return student;
    }

    public void setStudent(Set<student> student) {
        this.student = student;
    }

    public Set<faculty> getFaculty() {
        return faculty;
    }

    public void setFaculty(Set<faculty> faculty) {
        this.faculty = faculty;
    }

    public Set<admin> getAdmin() {
        return admin;
    }

    public void setAdmin(Set<admin> admin) {
        this.admin = admin;
    }

    public Set<course> getCourses() {
        return courses;
    }

    public void setCourses(Set<course> courses) {
        this.courses = courses;
    }

    public Optional<department> map(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    public Optional<department> map(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'map'");
    }

    
}
