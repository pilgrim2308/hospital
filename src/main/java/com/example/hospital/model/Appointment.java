package com.example.hospital.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String status;

    @Temporal(TemporalType.DATE)
    private Date appointment_date;

    @Temporal(TemporalType.TIME)
    private Date appointment_time;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private OutPatient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

    public Date getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(Date appointment_time) {
        this.appointment_time = appointment_time;
    }

    public OutPatient getPatient() {
        return patient;
    }

    public void setPatient(OutPatient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Appointment(String status, Date appointment_date, Date appointment_time, OutPatient patient, Doctor doctor) {
        this.status = status;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.patient = patient;
        this.doctor = doctor;
    }
}
