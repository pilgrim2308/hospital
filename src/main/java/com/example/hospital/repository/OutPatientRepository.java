package com.example.hospital.repository;

import com.example.hospital.model.InPatient;
import com.example.hospital.model.OutPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutPatientRepository extends JpaRepository <OutPatient,Long>{
    Optional<OutPatient> findByEmail(String email);

    @Query("Select i from InPatient i where i.mobile_no = ?1")
    Optional<OutPatient> findByMobileNo(String mobile_no);
}
