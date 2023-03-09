package com.example.HRFullStackback.controllers;




import com.example.HRFullStackback.models.Employee;
import com.example.HRFullStackback.repositories.IEmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return this.employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable UUID id){
        return this.employeeRepository.findById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepository.save(employee);
    }

    @DeleteMapping("{id}")
    public Employee deleteEmployeeById(@PathVariable UUID id) {
        return this.employeeRepository.removeById(id);
    }

    @PutMapping("{id}")
    public Employee updateEmployeeById(@PathVariable UUID id, @RequestBody Employee newEmployeeData){
        return this.employeeRepository.updateById(id,newEmployeeData);
    }

    @GetMapping("search")
    public List<Employee> searchEmployeeBy(
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String dni,
            @RequestParam(required = false)String position,
            @RequestParam(required = false)String location
    ){
        return this.employeeRepository.filterBy(name,dni,position,location);
    }







}



