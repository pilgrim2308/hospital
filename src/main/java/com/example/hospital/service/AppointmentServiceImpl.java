package com.example.hospital.service;

import com.example.hospital.model.Appointment;
import com.example.hospital.model.Doctor;
import com.example.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        Iterable<Appointment> appointments = appointmentRepository.findAll();
        appointments.forEach(list::add);
        return list;
    }

    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(long id) {
        Optional<Appointment> optional=appointmentRepository.findById(id);
        Appointment appointment = null;
        if(optional.isPresent()){
            appointment=optional.get();
        }
        else{
            throw new RuntimeException("Appointment Not Found for id !!!"+id);
        }
        return appointment;
    }

    @Override
    public void deleteAppointmentById(long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> getAllByPatientId(long id) {
        return appointmentRepository.getAllByPatient_Id(id);
    }
}
