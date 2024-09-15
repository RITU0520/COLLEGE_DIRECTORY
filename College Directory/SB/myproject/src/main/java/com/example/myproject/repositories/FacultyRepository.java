package com.example.myproject.repositories;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByUserId(Long userId);

    List<Faculty> findByDepartmentId(Long departmentId);

    List<Faculty> findByOfficeHours(String officeHours);

}

