package com.example.HRFullStackback.domain.services;

import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.infrastructure.repositories.IEmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployees(){

        List<Employee> employees = this.employeeRepository.findAll();
        if (employees == null) {
            employees=new ArrayList<>();
        }
        return employees;
    }

    public Employee getEmployeeById(UUID id){
        Employee employee;
        try {
            employee = this.employeeRepository.findById(id);
        }
        catch (NoSuchElementException e) {
            return null;
        }
        return employee;
    }
}
