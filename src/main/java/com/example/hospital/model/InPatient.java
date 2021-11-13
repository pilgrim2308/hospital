package com.example.hospital.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class InPatient extends User {

    @OneToMany
    private Collection<LaboratoryReport> laboratory_reports;

    @OneToMany
    Collection<Admission> admissions;

    public InPatient() {
    }

    public InPatient(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age) {
        super(first_name, last_name, email, password, mobile_no, gender, age);
    }

    public InPatient(String first_name, String last_name, String email, String password, String mobile_no, String gender, long age, Collection<Role> roles) {
        super(first_name, last_name, email, password, mobile_no, gender, age, roles);
    }

    public Collection<LaboratoryReport> getLaboratory_reports() {
        return laboratory_reports;
    }

    public void setLaboratory_reports(Collection<LaboratoryReport> laboratory_reports) {
        this.laboratory_reports = laboratory_reports;
    }

    public Collection<Admission> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(Collection<Admission> admissions) {
        this.admissions = admissions;
    }

}
