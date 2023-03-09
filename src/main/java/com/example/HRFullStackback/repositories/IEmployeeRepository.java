package com.example.HRFullStackback.repositories;

import com.example.HRFullStackback.models.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
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
