package com.example.hospital.repository;

import com.example.hospital.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
//    @Query("Select a from appointment a where a.patient_id=?1")
    List<Appointment> getAllByPatient_Id(long id);
}
