package com.example.myproject.repositories;


public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findByUserId(Long userId);

    List<Administrator> findByDepartmentId(Long departmentId);

}
