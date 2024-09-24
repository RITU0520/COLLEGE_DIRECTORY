package com.example.myproject.repositories;

import com.example.myproject.entities.faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface facultyRepositories extends JpaRepository<faculty, Long> {
}
