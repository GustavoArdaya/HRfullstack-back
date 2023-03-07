package com.example.HRFullStackback.controllers;




import com.example.HRFullStackback.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List <Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Perico Lospa Lotes" ),
            new Employee("Mihaela Gheorghiu" ),
            new Employee("Gustavo Ardaya" ),
            new Employee("Daniel Gallego" ),
            new Employee("Jaume Vidal" )

    ) );
    @GetMapping
    public List<Employee> getAllEmployees(){
        return this.employeeList;
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable UUID id){
        return this.employeeList.stream()
                .filter(
                        employee->employee.getId()
                                .equals(id))
                .findFirst()
                .get();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        this.employeeList.add(employee);
        return employee;
    }

    @DeleteMapping("{id}")
    public Employee deleteEmployeeById(@PathVariable UUID id) {
        Employee employeeToDelete = this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().get();
        this.employeeList.remove(employeeToDelete);
        return employeeToDelete;
    }

    @PutMapping("{id}")
    public Employee updateEmployeeById(@PathVariable UUID id, @RequestBody Employee newEmployeeData){
        Employee employeeToUpdate = this.employeeList.stream().filter(player -> player.getId().equals(id)).findFirst().get();
        employeeToUpdate.setName(newEmployeeData.getName());
        return employeeToUpdate;
    }

    @GetMapping("search")
    public List<Employee> searchEmployeeBy(@RequestParam(required = false)String name){
        if(name==null)return null;
        return this.employeeList.stream().filter(
                player->player.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase())
        ).toList();
    }

}



