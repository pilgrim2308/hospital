package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Doctor;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface DoctorService extends UserDetailsService {
    List<Doctor> getAllDoctors();
    Doctor save(UserRegistrationDto registrationDto);
    Doctor getDoctorById(long id);
    void deleteDoctorById(long id);
}
