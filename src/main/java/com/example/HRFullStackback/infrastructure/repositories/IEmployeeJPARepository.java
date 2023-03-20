package com.example.HRFullStackback.infrastructure.repositories;

import com.example.HRFullStackback.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeJPARepository extends JpaRepository<Employee,Long> {

}
