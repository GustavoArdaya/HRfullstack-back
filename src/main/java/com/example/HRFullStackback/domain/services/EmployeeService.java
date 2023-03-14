package com.example.HRFullStackback.domain.services;

import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.infrastructure.repositories.IEmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    public Employee createEmployee( Employee employee){
        return this.employeeRepository.save(employee);
    }
    public Employee deleteEmployeeById( UUID id) {
        return this.employeeRepository.removeById(id);
    }

    public Employee updateById(UUID id, Employee newEmployeeData) {
        return this.employeeRepository.updateById(id,newEmployeeData);
    }

    public List<Employee> filterBy(String name, String dni, String position, String location) {
        return this.employeeRepository.filterBy(name,dni,position,location);
    }
}
