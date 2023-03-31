package com.example.HRFullStackback.domain.services;

import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.infrastructure.repositories.IDepartmentJPARepository;
import com.example.HRFullStackback.infrastructure.repositories.IEmployeeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final IEmployeeJPARepository employeeRepository;
    private final IDepartmentJPARepository departmentRepository;

    public EmployeeService(IEmployeeJPARepository employeeRepository, IDepartmentJPARepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }


    public List<Employee> getAllEmployees(){

        return this.employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){

        var employee = this.employeeRepository.findById(id);
        if(employee.isPresent()) return employee.get();
        throw new RuntimeException("Could not find any Employee with the given id...");
    }
    public Employee createEmployee( Employee employee){
        var department=this.departmentRepository.findById(employee.getDepartment().getId()).orElseThrow(() -> new RuntimeException("Department Not Found"));
        employee.setDepartment(department);
        return this.employeeRepository.save(employee);
    }
    public Employee deleteEmployeeById( Long id) {

        var employee=getEmployeeById(id);
        this.employeeRepository.deleteById(id);
        return employee;
    }

    public Employee updateById(Long id, Employee newEmployeeData) {

        var department=this.departmentRepository.findById(newEmployeeData.getDepartment().getId()).orElseThrow(() -> new RuntimeException("Department Not Found"));
        newEmployeeData.setDepartment(department);
        newEmployeeData.setId(id);
        return employeeRepository.save(newEmployeeData);
    }


    public List<Employee> filterBy(String nameParam, String dniParam, String positionParam, String locationParam) {

        String name=nameParam!=null?nameParam:"";
        String dni=dniParam!=null?dniParam:"";
        String position=positionParam!=null?positionParam:"";
        String location=locationParam!=null?locationParam:"";
        return this.employeeRepository
            .findByNameContainingIgnoreCaseAndDniContainingIgnoreCaseAndPositionContainingIgnoreCaseAndLocationContainingIgnoreCase(name,dni,position,location);
    }

}

