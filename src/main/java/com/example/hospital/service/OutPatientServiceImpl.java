package com.example.hospital.service;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.model.OutPatient;
import com.example.hospital.model.Role;
import com.example.hospital.repository.OutPatientRepository;
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
public class OutPatientServiceImpl implements OutPatientService{
    @Autowired
    private OutPatientRepository outPatientRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<OutPatient> getAllOutPatients() {
        return outPatientRepository.findAll();
    }

    @Override
    public OutPatient save(PatientRegistrationDto registrationDto) {
        OutPatient outPatient = new OutPatient(registrationDto.getFirst_name(),registrationDto.getLast_name(),registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getMobile_no(), registrationDto.getGender(), registrationDto.getAge(),Arrays.asList(new Role("OUTPATIENT")));
        return outPatientRepository.save(outPatient);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<OutPatient> optional = outPatientRepository.findByEmail(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("OutPatient not found");
        }
        OutPatient outPatient=optional.get();
        return new org.springframework.security.core.userdetails.User(outPatient.getEmail(),outPatient.getPassword(),mapRolesToAuthorities(outPatient.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public OutPatient getOutPatientById(long id) {
        Optional<OutPatient> optional=outPatientRepository.findById(id);
        OutPatient outPatient = null;
        if(optional.isPresent()){
            outPatient=optional.get();
        }
        else{
            throw new RuntimeException("OutPatient Not Found for id !!!"+id);
        }
        return outPatient;
    }

    @Override
    public void deleteOutPatientById(long id) {
        outPatientRepository.deleteById(id);
    }

    @Override
    public OutPatient getOutPatientByEmail(String email) {
        Optional<OutPatient> optional=outPatientRepository.findByEmail(email);
        OutPatient outPatient = null;
        if(optional.isPresent()){
            outPatient=optional.get();
        }
        else{
            throw new RuntimeException("OutPatient Not Found for email !!!"+email);
        }
        return outPatient;
    }
    @Override
    public OutPatient getOutPatientByMobileNo(String mobile_no) {
        Optional<OutPatient> optional=outPatientRepository.findByMobileNo(mobile_no);
        OutPatient outPatient = null;
        if(optional.isPresent()){
            outPatient=optional.get();
        }
        else{
            throw new RuntimeException("OutPatient Not Found for mobile no !!!"+mobile_no);
        }
        return outPatient;
    }
}
