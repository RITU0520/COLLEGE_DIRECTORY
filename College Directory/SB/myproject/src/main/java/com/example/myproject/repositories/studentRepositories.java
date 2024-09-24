package com.example.myproject.repositories;

import com.example.myproject.entities.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepositories extends JpaRepository<student, Long> {
}
