package com.example.HRFullStackback.apiService.controllers;

import com.example.HRFullStackback.domain.models.Department;
import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.domain.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = this.departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        if (id == null) return ResponseEntity.badRequest().header("Id path variable must be present and valid").build();
        Department department=this.departmentService.getDepartmentById(id);
        if (department == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department newDepartment=this.departmentService.createDepartment(department);
        return ResponseEntity.ok(newDepartment);

    }

}
