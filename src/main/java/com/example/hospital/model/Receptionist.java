package com.example.hospital.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Receptionist extends User {

    private long salary;
    private String designation;
    private String department;

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Receptionist() {
    }

    public Receptionist(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age, Collection<Role> roles, long salary, String designation, String department) {
        super(first_name, last_name, email, password, mobile_no, gender, age, roles);
        this.salary = salary;
        this.designation = designation;
        this.department = department;
    }
}
