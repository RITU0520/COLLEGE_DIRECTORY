package com.example.myproject.repositories;

import com.example.myproject.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends JpaRepository<user, Long> {
}
