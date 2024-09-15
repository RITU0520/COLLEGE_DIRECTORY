package com.example.myproject.repositories;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUserId(Long userId);

    List<Student> findByDepartmentId(Long departmentId);

    List<Student> findByYear(String year);

}
