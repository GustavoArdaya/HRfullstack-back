package com.example.HRFullStackback.infrastructure.repositories;

import com.example.HRFullStackback.domain.models.Employee;

import java.util.List;
import java.util.UUID;

public interface IEmployeeRepository {

    public List<Employee> findAll();
    public Employee findById(UUID id);
    public Employee save(Employee employee);
    public Employee removeById(UUID id);
    public Employee updateById(UUID id, Employee newEmployeeData);
    public List<Employee> filterBy(
            String name,
            String dni,
            String position,
            String location
    );
}
