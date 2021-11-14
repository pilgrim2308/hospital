package com.example.hospital.repository;

import com.example.hospital.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission,Long> {
    List<Admission> getAllByPatient_Id(long id);
}
