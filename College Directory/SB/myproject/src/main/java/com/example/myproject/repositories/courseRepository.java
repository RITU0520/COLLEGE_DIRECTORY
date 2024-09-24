package com.example.myproject.repositories;

import com.example.myproject.entities.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<course, Long> {
}
