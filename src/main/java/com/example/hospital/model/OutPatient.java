package com.example.hospital.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class OutPatient extends User{

    @OneToMany
    @JoinColumn(name="appointment_ids",nullable = true)
    private Collection<Appointment> appointments;

    public Collection<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public OutPatient() {
    }

    public OutPatient(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age, Collection<Role> roles) {
        super(first_name, last_name, email, password, mobile_no, gender, age, roles);
    }
}
