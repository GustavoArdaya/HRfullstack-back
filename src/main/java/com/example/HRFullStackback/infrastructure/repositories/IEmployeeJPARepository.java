package com.example.HRFullStackback.infrastructure.repositories;

import com.example.HRFullStackback.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeJPARepository extends JpaRepository<Employee,Long> {
//    @Query("SELECT * FROM EMployees" +
//            "Where LOWER(name) like LOWER('%?1%') and ...)
    List<Employee> findByNameContainingIgnoreCaseAndDniContainingIgnoreCaseAndPositionContainingIgnoreCaseAndLocationContainingIgnoreCase(String name,String dni,String position,String location);

}
