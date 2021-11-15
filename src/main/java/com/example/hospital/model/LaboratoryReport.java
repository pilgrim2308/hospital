package com.example.hospital.model;

import javax.persistence.*;

@Entity
public class LaboratoryReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "inpatient_id", nullable = true)
    private InPatient inpatient;

    @ManyToOne
    @JoinColumn(name = "outpatient_id", nullable = true)
    private OutPatient outPatient;

    public LaboratoryReport(Doctor doctor, InPatient inpatient, OutPatient outPatient) {
        this.doctor = doctor;
        this.inpatient = inpatient;
        this.outPatient = outPatient;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public InPatient getInpatient() {
        return inpatient;
    }

    public void setInpatient(InPatient inpatient) {
        this.inpatient = inpatient;
    }

    public OutPatient getOutPatient() {
        return outPatient;
    }

    public void setOutPatient(OutPatient outPatient) {
        this.outPatient = outPatient;
    }

    public LaboratoryReport() {
    }
}
