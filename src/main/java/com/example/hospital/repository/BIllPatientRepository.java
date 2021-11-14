package com.example.hospital.repository;

import com.example.hospital.model.BillPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BIllPatientRepository extends JpaRepository<BillPatient,Long> {
}
