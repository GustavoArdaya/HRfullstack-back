package com.example.HRFullStackback.domain.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public void updateAtr(Department newDepartmentData) {
        String name= newDepartmentData.getName();
        this.name=name!=null?name:this.name;
    }
}
