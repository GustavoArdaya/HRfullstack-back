package com.example.HRFullStackback.models;
import java.util.UUID;

public class Employee  {
    private UUID id;
    private String name;

    public Employee(String name) {
        this();
        this.name = name;
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
}

