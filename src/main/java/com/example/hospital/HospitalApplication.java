package com.example.hospital;

import com.example.hospital.model.Admin;
import com.example.hospital.model.Role;
import com.example.hospital.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HospitalApplication {



    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

}
