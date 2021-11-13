package com.example.hospital.service;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.InPatient;
import com.example.hospital.model.Receptionist;
import com.example.hospital.model.Role;
import com.example.hospital.repository.InPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InPatientServiceImpl implements InPatientService{
    
    @Autowired
    private InPatientRepository inPatientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public List<InPatient> getAllInPatients() {
        return inPatientRepository.findAll();
    }

    @Override
    public InPatient save(PatientRegistrationDto registrationDto) {
        InPatient inPatient = new InPatient(registrationDto.getFirst_name(),registrationDto.getLast_name(),registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getMobile_no(),registrationDto.getGender(), registrationDto.getAge(), Arrays.asList(new Role("INPATIENT")));
        return inPatientRepository.save(inPatient);
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<InPatient> optional = inPatientRepository.findByEmail(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("InPatient not found");
        }
        InPatient inPatient=optional.get();
        return new org.springframework.security.core.userdetails.User(inPatient.getEmail(),inPatient.getPassword(),mapRolesToAuthorities(inPatient.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public InPatient getInPatientById(long id) {
        Optional<InPatient> optional=inPatientRepository.findById(id);
        InPatient inPatient = null;
        if(optional.isPresent()){
            inPatient=optional.get();
        }
        else{
            throw new RuntimeException("InPatient Not Found for id !!!"+id);
        }
        return inPatient;
    }

    @Override
    public void deleteInPatientById(long id) {
        inPatientRepository.deleteById(id);
    }

    @Override
    public InPatient getInPatientByEmail(String email) {
        Optional<InPatient> optional=inPatientRepository.findByEmail(email);
        InPatient inPatient = null;
        if(optional.isPresent()){
            inPatient=optional.get();
        }
        else{
            throw new RuntimeException("InPatient Not Found for email !!!"+email);
        }
        return inPatient;
    }
    @Override
    public InPatient getInPatientByMobileNo(String mobile_no) {
        Optional<InPatient> optional=inPatientRepository.findByMobileNo(mobile_no);
        InPatient inPatient = null;
        if(optional.isPresent()){
            inPatient=optional.get();
        }
        else{
            throw new RuntimeException("InPatient Not Found for mobile no !!!"+mobile_no);
        }
        return inPatient;
    }
}
