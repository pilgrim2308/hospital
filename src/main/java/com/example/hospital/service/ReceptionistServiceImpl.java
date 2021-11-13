package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Receptionist;
import com.example.hospital.model.Role;
import com.example.hospital.repository.ReceptionistRepository;
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
public class ReceptionistServiceImpl implements ReceptionistService{

    @Autowired
    private ReceptionistRepository receptionistRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ReceptionistServiceImpl(ReceptionistRepository receptionistRepository) {
        super();
        this.receptionistRepository = receptionistRepository;
    }

    public Receptionist save(UserRegistrationDto registrationDto) {
//        Role receptionist_role = roleRepository.findByName("DOCTOR");
        Receptionist receptionist = new Receptionist(registrationDto.getFirst_name(),registrationDto.getLast_name(),registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getMobile_no(),registrationDto.getGender(), registrationDto.getAge(),Arrays.asList(new Role("RECEPTIONIST")) ,registrationDto.getSalary(), registrationDto.getDesignation(),registrationDto.getDepartment());
        return receptionistRepository.save(receptionist);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Receptionist receptionist = receptionistRepository.findByEmail(username);
        if(receptionist == null){
            throw new UsernameNotFoundException("Receptionist not found");
        }
        return new org.springframework.security.core.userdetails.User(receptionist.getEmail(),receptionist.getPassword(),mapRolesToAuthorities(receptionist.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    
    @Override
    public Receptionist getReceptionistById(long id) {
        Optional<Receptionist> optional=receptionistRepository.findById(id);
        Receptionist receptionist = null;
        if(optional.isPresent()){
            receptionist=optional.get();
        }
        else{
            throw new RuntimeException("Receptionist Not Found for id !!!"+id);
        }
        return receptionist;
    }

    @Override
    public void deleteReceptionistById(long id) {
        receptionistRepository.deleteById(id);
    }
}
