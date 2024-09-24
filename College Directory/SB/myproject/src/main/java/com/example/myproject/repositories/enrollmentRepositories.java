package com.example.myproject.repositories;

import com.example.myproject.entities.enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface enrollmentRepositories extends JpaRepository<enrollment, Long> {
}
