package com.example.hospital.repository;

import com.example.hospital.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository <Charge,Long>{
    Charge save(Charge charge);
}
