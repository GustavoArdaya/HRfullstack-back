package com.example.HRFullStackback.apiService.controllers;




import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.domain.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * retorna noContent -codigo 500 cuando la lista esta nula
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = this.employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id){
        // return this.employeeRepository.findById(id);
        if (id == null) return ResponseEntity.badRequest().header("Id path variable must be present and valid").build();
        Employee employee=this.employeeService.getEmployeeById(id);
        if (employee == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employee);
    }

//    @PostMapping
//    public Employee createEmployee(@RequestBody Employee employee){
//        return this.employeeRepository.save(employee);
//    }
//
//    @DeleteMapping("{id}")
//    public Employee deleteEmployeeById(@PathVariable UUID id) {
//        return this.employeeRepository.removeById(id);
//    }
//
//    @PutMapping("{id}")
//    public Employee updateEmployeeById(@PathVariable UUID id, @RequestBody Employee newEmployeeData){
//        return this.employeeRepository.updateById(id,newEmployeeData);
//    }
//
//    @GetMapping("search")
//    public List<Employee> searchEmployeeBy(
//            @RequestParam(required = false)String name,
//            @RequestParam(required = false)String dni,
//            @RequestParam(required = false)String position,
//            @RequestParam(required = false)String location
//    ){
//        return this.employeeRepository.filterBy(name,dni,position,location);
//    }








}



