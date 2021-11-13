package com.example.hospital.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false)
    private InPatient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Admission(InPatient patient, Doctor doctor, Room room, String status, Date admission_date, Date discharge_date) {
        this.patient = patient;
        this.doctor = doctor;
        this.room = room;
        this.status = status;
        this.admission_date = admission_date;
        this.discharge_date = discharge_date;
    }

    @ManyToOne
    @JoinColumn(name = "room_id",nullable = true)
    private Room room;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InPatient getPatient() {
        return patient;
    }

    public void setPatient(InPatient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public Date getDischarge_date() {
        return discharge_date;
    }

    public void setDischarge_date(Date discharge_date) {
        this.discharge_date = discharge_date;
    }

    public Admission() {
    }

    public Admission(InPatient patient, Doctor doctor, String status, Date admission_date) {
        this.patient = patient;
        this.doctor = doctor;
        this.status = status;
        this.admission_date = admission_date;
    }

    private String status;

    private Date admission_date;

    private Date discharge_date;

}
