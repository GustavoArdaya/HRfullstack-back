package com.example.HRFullStackback.domain.services;

import com.example.HRFullStackback.domain.models.Department;
import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.infrastructure.repositories.IDepartmentJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final IDepartmentJPARepository departmentRepository;

    public DepartmentService(IDepartmentJPARepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return this.departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        var department = this.departmentRepository.findById(id);
        if(department.isPresent()) return department.get();
        throw new RuntimeException();
    }

    public Department createDepartment(Department department) {
                   return this.departmentRepository.save(department);
    }
}
