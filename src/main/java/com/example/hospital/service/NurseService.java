package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.Nurse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface NurseService extends UserDetailsService {
    Nurse save(UserRegistrationDto registrationDto);
    Nurse getNurseById(long id);
    void deleteNurseById(long id);
}
