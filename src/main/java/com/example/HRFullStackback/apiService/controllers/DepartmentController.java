package com.example.HRFullStackback.apiService.controllers;

import com.example.HRFullStackback.domain.models.Department;
import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.domain.services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = this.departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('USER') || hasAuthority('ADMIN')")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        if (id == null) return ResponseEntity.badRequest().header("Id path variable must be present and valid").build();
        Department department=this.departmentService.getDepartmentById(id);
        if (department == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(department);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department newDepartment=this.departmentService.createDepartment(department);
        return ResponseEntity.ok(newDepartment);

    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Department> deleteDepartmentById(@PathVariable Long id) {
        Department deleteDepartment=this.departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok(deleteDepartment);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable Long id, @RequestBody Department newDepartmentData){
        Department updatedDepartment = this.departmentService.updateById(id,newDepartmentData);
        return ResponseEntity.ok(updatedDepartment);
    }

}
