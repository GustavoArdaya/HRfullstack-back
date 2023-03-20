package com.example.HRFullStackback.infrastructure.repositories;

import com.example.HRFullStackback.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeJPARepository extends JpaRepository<Employee,Long> {

    List<Employee> findByNameContainingIgnoreCaseAndDniContainingIgnoreCaseAndPositionContainingIgnoreCaseAndLocationContainingIgnoreCase(String name,String dni,String position,String location);
}
