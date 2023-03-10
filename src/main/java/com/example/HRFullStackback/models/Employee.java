package com.example.HRFullStackback.models;
import java.util.Date;
import java.util.UUID;

public class Employee  {
    private UUID id;
    private String name;
    private String lastName;
    private String photo;
    private String position;
    private String phone;
    private String email;
    private String location;
    private Double salary;
    private Date joiningDate;
    private Date birthDate;
    private String dni;


    public Employee(
            String name,
            String lastName,
            String photo,
            String position,
            String phone,
            String email,
            String location,
            String dni,
            Double salary,
            Date joiningDate,
            Date birthDate

    ) {
        this();
        this.name = name;
        this.lastName = lastName;
        this.photo = photo;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.birthDate = birthDate;
        this.dni = dni;
    }

    public Employee() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Updates the atributes of the current instance with the values of the atributes in the given instance, if they are not null
     * @param src Instance containing the new values to store
     */
    public void updateAtr(Employee src){
        String name=src.getName();
        String lastName=src.getLastName();
        String photo=src.getPhoto();
        String position=src.getPosition();
        String phone=src.getPhone();
        String email=src.getEmail();
        String location=src.getLocation();
        String dni=src.getDni();
        Double salary=src.getSalary();
        Date joiningDate=src.getJoiningDate();
        Date birthDate=src.getBirthDate();

        this.name=name!=null?name:this.name;
        this.lastName=lastName!=null?lastName:this.lastName;
        this.photo=photo!=null?photo:this.photo;
        this.position=position!=null?position:this.position;
        this.phone=phone!=null?phone:this.phone;
        this.email=email!=null?email:this.email;
        this.location=location!=null?location:this.location;
        this.dni=dni!=null?dni:this.dni;
        this.salary=salary!=null?salary:this.salary;
        this.joiningDate=joiningDate!=null?joiningDate:this.joiningDate;
        this.birthDate=birthDate!=null?birthDate:this.birthDate;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", photo='" + photo + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", birthDate=" + birthDate +
                ", dni='" + dni + '\'' +
                '}';
    }
}

