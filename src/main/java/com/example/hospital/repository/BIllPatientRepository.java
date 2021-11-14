package com.example.hospital.repository;

import com.example.hospital.model.BillPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BIllPatientRepository extends JpaRepository<BillPatient,Long> {
    List<BillPatient> getAllByInPatient_Id(long id);
}
