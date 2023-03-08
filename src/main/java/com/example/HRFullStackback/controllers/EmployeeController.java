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
    public List<Employee> searchEmployeeBy(
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String dni,
            @RequestParam(required = false)String position,
            @RequestParam(required = false)String location
    ){
        List<Employee> filteredList=this.employeeList;
        if(name!=null)
            filteredList= filterListByName(filteredList,name);
        if(dni!=null)
            filteredList= filterListByDni(filteredList,dni);
        if(position!=null)
            filteredList= filterListByPosition(filteredList,position);
        if(location!=null)
            filteredList= filterListByLocation(filteredList,location);
        return filteredList;
    }

    private List<Employee> filterListByPosition(List<Employee> list,String position) {
        return list.stream().filter(
                player -> player.getPosition()
                        .toLowerCase()
                        .contains(position.toLowerCase())
        ).toList();
    }
    private List<Employee> filterListByLocation(List<Employee> list,String location) {
        return list.stream().filter(
                player -> player.getLocation()
                        .toLowerCase()
                        .contains(location.toLowerCase())
        ).toList();
    }

    private List<Employee> filterListByDni(List<Employee>list,String dni) {
        return list.stream().filter(
                player -> player.getDni()
                        .toLowerCase()
                        .contains(dni.toLowerCase())
        ).toList();
    }

    private List<Employee>filterListByName(List<Employee>list,String name){
        return list.stream().filter(
                player->player.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase())
        ).toList();
    }





}



