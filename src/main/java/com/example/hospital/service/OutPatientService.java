package com.example.hospital.service;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.model.OutPatient;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface OutPatientService extends UserDetailsService {
    List<OutPatient> getAllOutPatients();
    OutPatient save(PatientRegistrationDto registrationDto);
    OutPatient getOutPatientById(long id);
    OutPatient getOutPatientByEmail(String email);
    OutPatient getOutPatientByMobileNo(String mobile_no);
    void deleteOutPatientById(long id);
}
