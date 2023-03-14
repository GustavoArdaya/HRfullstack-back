package com.example.HRFullStackback.apiService.controllers;




import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.infrastructure.repositories.IEmployeeRepository;
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

    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * retorna noContent -codigo 204 cuando la lista esta vacia o nula
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        //return this.employeeRepository.findAll();
        List<Employee> employees = this.employeeRepository.findAll();
        if (employees == null || employees.size()==0) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id){
        // return this.employeeRepository.findById(id);
        if (id == null) return ResponseEntity.badRequest().build();
        Employee employee;
        try {
            employee = this.employeeRepository.findById(id);
        }
            catch (NoSuchElementException e) { return ResponseEntity.noContent().build();
            }
            if (employee == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(employee);


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



