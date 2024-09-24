package com.example.myproject.repositories;

import com.example.myproject.entities.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departmentRepositories extends JpaRepository<department, Long> {
}
