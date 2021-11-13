package com.example.hospital.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Doctor extends User{

    private long salary;
    private String designation;
    private String department;

//    public Doctor(String first_name, String last_name, String email, String password, String mobile_no, Collection<Role> roles, long salary, String designation, String department) {
//        super(first_name, last_name, email, password, mobile_no, roles);
//        this.salary = salary;
//        this.designation = designation;
//        this.department = department;
//    }

//    public Doctor(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age, long salary, String designation, String department) {
//        super(first_name, last_name, email, password, mobile_no, gender, age);
//        this.salary = salary;

    public Doctor(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age, Collection<Role> roles, long salary, String designation, String department) {
        super(first_name, last_name, email, password, mobile_no, gender, age, roles);
        this.salary = salary;
        this.designation = designation;
        this.department = department;
    }
//        this.designation = designation;
//        this.department = department;
//    }

    @OneToMany
    @JoinColumn(name="appointment_ids",nullable = true)
    private Collection<Appointment> appointments;

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

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Collection<Admission> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(Collection<Admission> admissions) {
        this.admissions = admissions;
    }

    @OneToMany
    @JoinColumn(name = "admission_ids",nullable = true)
    private Collection<Admission> admissions;

    public Doctor() {
        super();
    }
}
