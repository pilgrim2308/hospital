package com.example.hospital;

import com.example.hospital.config.SecurityConfiguration;
import com.example.hospital.model.Admin;
import com.example.hospital.model.Role;
import com.example.hospital.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StarterClass implements CommandLineRunner {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Override
    public void run(String...args) throws Exception {
//        adminRepository.checks();
//        Admin admin=new Admin("Hitesh","Jindal","admin@gmail.com",securityConfiguration.passwordEncoder().encode("0000"),"+919999999999","M",20, Arrays.asList(new Role("ADMIN")));
//        Admin admin1=adminRepository.save(admin);
//        logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));
        System.out.println("admin created");
    }
}
