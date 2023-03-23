package com.example.HRFullStackback.domain.services;

import com.example.HRFullStackback.domain.models.Employee;
import com.example.HRFullStackback.infrastructure.repositories.IEmployeeJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class EmployeeService {

    private final IEmployeeJPARepository employeeRepository;

    public EmployeeService(IEmployeeJPARepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
        return this.employeeRepository.save(employee);
    }
    public Employee deleteEmployeeById( Long id) {

        var employee=getEmployeeById(id);
        this.employeeRepository.deleteById(id);
        return employee;
    }

    public Employee updateById(Long id, Employee newEmployeeData) {

        var employee=getEmployeeById(id);
        employee.updateAtr(newEmployeeData);
        employeeRepository.save(employee);
        return employee;
    }


    public List<Employee> filterBy(String nameParam, String dniParam, String positionParam, String locationParam) {

        String name=nameParam!=null?nameParam:"";
        String dni=dniParam!=null?dniParam:"";
        String position=positionParam!=null?positionParam:"";
        String location=locationParam!=null?locationParam:"";
        System.out.println(name);
        System.out.println(dni);
        System.out.println(position);
        System.out.println(location);
        return this.employeeRepository.findByNameContainingIgnoreCaseAndDniContainingIgnoreCaseAndPositionContainingIgnoreCaseAndLocationContainingIgnoreCase(name,dni,position,location);
    }

}

