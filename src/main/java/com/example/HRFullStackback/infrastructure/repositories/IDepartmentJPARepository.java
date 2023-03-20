package com.example.HRFullStackback.infrastructure.repositories;

import com.example.HRFullStackback.domain.models.Department;
import com.example.HRFullStackback.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentJPARepository extends JpaRepository<Department,Long> {

}
