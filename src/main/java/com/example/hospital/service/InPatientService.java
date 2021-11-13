package com.example.hospital.service;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.InPatient;

import java.util.List;

public interface InPatientService {
    List<InPatient> getAllInPatients();
    InPatient save(PatientRegistrationDto registrationDto);
    InPatient getInPatientById(long id);
    InPatient getInPatientByEmail(String email);
    InPatient getInPatientByMobileNo(String mobile_no);
    void deleteInPatientById(long id);
}
