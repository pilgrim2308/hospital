package com.example.hospital.repository;

import com.example.hospital.model.InPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Repository
public interface InPatientRepository extends JpaRepository <InPatient,Long>{
    Optional<InPatient> findByEmail(String email);

    @Query("Select i from InPatient i where i.mobile_no = ?1")
    Optional<InPatient> findByMobileNo(String mobile_no);
}
