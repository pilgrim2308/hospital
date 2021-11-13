package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Receptionist;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ReceptionistService extends UserDetailsService {
    Receptionist save(UserRegistrationDto registrationDto);
    Receptionist getReceptionistById(long id);
    void deleteReceptionistById(long id);
}
