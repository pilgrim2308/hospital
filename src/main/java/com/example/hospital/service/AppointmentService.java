package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Appointment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    void save(Appointment appointment);
    Appointment getAppointmentById(long id);
    void deleteAppointmentById(long id);
    List<Appointment> getAllByPatientId(long id);
}
