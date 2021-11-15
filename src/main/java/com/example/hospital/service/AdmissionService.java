package com.example.hospital.service;

import com.example.hospital.model.Admission;
import com.example.hospital.model.Appointment;

import java.util.List;

public interface AdmissionService {
    void save(Admission admission);
    Admission getAdmissionById(long id);
    void deleteAdmissionById(long id);
    List<Admission> getAllByPatientId(long id);
    List<Admission> getAllByStatus(String string);
}
