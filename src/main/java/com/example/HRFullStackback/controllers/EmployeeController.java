package com.example.HRFullStackback.controllers;




import com.example.HRFullStackback.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List <Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Perico","Lospa Lotes", "", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Mihaela","Gheorghiu","", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Gustavo","Ardaya", "", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Daniel","Gallego" ,"", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Jaume","Vidal" ,"", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05"))
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



