package com.example.hospital.repository;

import com.example.hospital.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
    Admin save(Admin admin);

//    @Query(value = "SET FOREIGN_KEY_CHECKS=0")
//    void checks();
}
