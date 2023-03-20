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
        throw new RuntimeException();
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

    /* TODO Refactor
        public List<Employee> filterBy(String name, String dni, String position, String location) {

            return this.employeeRepository.findAll();
            //return this.employeeRepository.filterBy(name,dni,position,location);
        }
    */
}

