package com.example.HRFullStackback.repositories;

import com.example.HRFullStackback.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeInMemoryRepository implements IEmployeeRepository {
    List <Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Perico","Lospa Lotes", "", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Mihaela","Gheorghiu","", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Gustavo","Ardaya", "", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Daniel","Gallego" ,"", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Jaume","Vidal" ,"", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05"))
    ) );
    @Override
    public List<Employee> findAll() {
        return this.employeeList;
    }

    @Override
    public Employee findById(UUID id) {
        return this.employeeList.stream()
                .filter(
                        employee->employee.getId()
                                .equals(id))
                .findFirst()
                .get();
    }

    @Override
    public Employee save(Employee employee) {
        this.employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removeById(UUID id) {
        Employee employeeToDelete = this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().get();
        this.employeeList.remove(employeeToDelete);
        return employeeToDelete;
    }

    @Override
    public Employee updateById(UUID id, Employee newEmployeeData) {
        Employee employeeToUpdate = this.employeeList.stream().filter(player -> player.getId().equals(id)).findFirst().get();
        employeeToUpdate.setName(newEmployeeData.getName());
        return employeeToUpdate;
    }

    @Override
    public List<Employee> filterBy(String name, String dni, String position, String location) {
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
