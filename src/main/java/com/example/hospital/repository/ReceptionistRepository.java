package com.example.hospital.repository;

import com.example.hospital.model.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist,Long> {
    Receptionist findByEmail(String email);
}
