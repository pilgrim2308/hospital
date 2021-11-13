package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.Role;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public Doctor save(UserRegistrationDto registrationDto) {
//        Role doctor_role = roleRepository.findByName("DOCTOR");
        Doctor doctor = new Doctor(registrationDto.getFirst_name(),registrationDto.getLast_name(),registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getMobile_no(),registrationDto.getGender(), registrationDto.getAge(), Arrays.asList(new Role("DOCTOR")), registrationDto.getSalary(), registrationDto.getDesignation(),registrationDto.getDepartment());
        return doctorRepository.save(doctor);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = doctorRepository.findByEmail(username);
        if(doctor == null){
            throw new UsernameNotFoundException("Doctor not found");
        }
        return new org.springframework.security.core.userdetails.User(doctor.getEmail(),doctor.getPassword(),mapRolesToAuthorities(doctor.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        Iterable<Doctor> doctors = doctorRepository.findAll();
        doctors.forEach(list::add);
        return list;
    }

    @Override
    public Doctor getDoctorById(long id) {
        Optional<Doctor> optional=doctorRepository.findById(id);
        Doctor doctor = null;
        if(optional.isPresent()){
            doctor=optional.get();
        }
        else{
            throw new RuntimeException("Doctor Not Found for id !!!"+id);
        }
        return doctor;
    }

    @Override
    public void deleteDoctorById(long id) {
        doctorRepository.deleteById(id);
    }
}
