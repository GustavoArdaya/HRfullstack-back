package com.example.HRFullStackback.infrastructure.repositories;

import com.example.HRFullStackback.domain.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeInMemoryRepository implements IEmployeeRepository {
    List <Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Perico","Lospa Lotes", "./photos/default.png", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Mihaela","Gheorghiu","./photos/MihaelaGheorghiu.jpg", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Gustavo","Ardaya", "./photos/GustavoArdaya.jpg", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Daniel","Gallego" ,"./photos/DanielGallego.png", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05")),
            new Employee("Jaume","Vidal" ,"./photos/JaumeVidal.png", "Currante","600123456","perico@lospa.com","Barcelona","12345678Z",1234.56,new Date("2020/04/27"),new Date("1987/07/05"))
    ) );

    /**
     * Retrieve all the employees stored in the repository
     * @return List of all employees stored in the repository
     */
    @Override
    public List<Employee> findAll() {
        return this.employeeList;
    }

    /**
     * Retrieves an Employee object from the repository that has an id matching the one received by param
     * @param id id of the employee to find
     * @return Employee with the matching id stored in the repository
     */
    @Override
    public Employee findById(UUID id) {
        return this.employeeList.stream()
                .filter(
                        employee->employee.getId()
                                .equals(id))
                .findFirst()
                .get();
    }

    /**
     * Saves a given employee instance by param into the repository
     * @param employee Employee instance to save in the repository
     * @return In case of  success, the employee instance given
     */
    @Override
    public Employee save(Employee employee) {
        this.employeeList.add(employee);
        return employee;
    }

    /**
     * Removes an Employee instance from the repository that has a matching id with the one given by param
     * @param id id of the employee to remove
     * @return If success, returns the instance removed from the repository
     */
    @Override
    public Employee removeById(UUID id) {
        Employee employeeToDelete = this.employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().get();
        this.employeeList.remove(employeeToDelete);
        return employeeToDelete;
    }

    /**
     * Updates an Employee instance from the repository that has a matching id with the one given by param, with
     * the new data also given by param
     * @param id id of the employee to update
     * @param newEmployeeData employee instance with the new data
     * @return if success, the updated instance
     */
    @Override
    public Employee updateById(UUID id, Employee newEmployeeData) {
        Employee employeeToUpdate = this.employeeList.stream().filter(player -> player.getId().equals(id)).findFirst().get();
        employeeToUpdate.updateAtr(newEmployeeData);
        return employeeToUpdate;
    }

    /**
     * Returns a list with all the Employee instances in the repository that match the given params, if they aren't null
     * @param name
     * @param dni
     * @param position
     * @param location
     * @return
     */
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

    /**
     * Helper method to filter the given List of Employees by the position given by param
     * @param list
     * @param position
     * @return The filtered list
     */
    private List<Employee> filterListByPosition(List<Employee> list,String position) {
        return list.stream().filter(
                player -> player.getPosition()
                        .toLowerCase()
                        .contains(position.toLowerCase())
        ).toList();
    }

    /**
     * Helper method to filter the given List of Employees by the location given by param
     * @param list
     * @param location
     * @return The filtered list
     */
    private List<Employee> filterListByLocation(List<Employee> list,String location) {
        return list.stream().filter(
                player -> player.getLocation()
                        .toLowerCase()
                        .contains(location.toLowerCase())
        ).toList();
    }

    /**
     * Helper method to filter the given List of Employees by the dni given by param
     * @param list
     * @param dni
     * @return The filtered list
     */
    private List<Employee> filterListByDni(List<Employee>list,String dni) {
        return list.stream().filter(
                player -> player.getDni()
                        .toLowerCase()
                        .contains(dni.toLowerCase())
        ).toList();
    }

    /**
     * Helper method to filter the given List of Employees by the name given by param
     * @param list
     * @param name
     * @return The filtered list
     */
    private List<Employee>filterListByName(List<Employee>list,String name){
        return list.stream().filter(
                player->player.getName()
                        .toLowerCase()
                        .contains(name.toLowerCase())
        ).toList();
    }
}
