package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Nurse;
import com.example.hospital.model.Role;
import com.example.hospital.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NurseServiceImpl implements NurseService{
    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public NurseServiceImpl(NurseRepository nurseRepository) {
        super();
        this.nurseRepository = nurseRepository;
    }

    public Nurse save(UserRegistrationDto registrationDto) {
//        Role nurse_role = roleRepository.findByName("DOCTOR");
        Nurse nurse = new Nurse(registrationDto.getFirst_name(),registrationDto.getLast_name(),registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getMobile_no(),registrationDto.getGender(), registrationDto.getAge(), Arrays.asList(new Role("NURSE")),registrationDto.getSalary(), registrationDto.getDesignation(),registrationDto.getDepartment());
        return nurseRepository.save(nurse);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nurse nurse = nurseRepository.findByEmail(username);
        if(nurse == null){
            throw new UsernameNotFoundException("Nurse not found");
        }
        return new org.springframework.security.core.userdetails.User(nurse.getEmail(),nurse.getPassword(),mapRolesToAuthorities(nurse.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public Nurse getNurseById(long id) {
        Optional<Nurse> optional=nurseRepository.findById(id);
        Nurse nurse = null;
        if(optional.isPresent()){
            nurse=optional.get();
        }
        else{
            throw new RuntimeException("Nurse Not Found for id !!!"+id);
        }
        return nurse;
    }

    @Override
    public void deleteNurseById(long id) {
        nurseRepository.deleteById(id);
    }
}
