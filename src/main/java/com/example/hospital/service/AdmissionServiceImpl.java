package com.example.hospital.service;

import com.example.hospital.model.Admission;
import com.example.hospital.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionServiceImpl implements AdmissionService{

    @Autowired
    private AdmissionRepository admissionRepository;

    @Override
    public void save(Admission admission) {
        admissionRepository.save(admission);
    }

    @Override
    public Admission getAdmissionById(long id) {
        Optional<Admission> optional=admissionRepository.findById(id);
        Admission admission = null;
        if(optional.isPresent()){
            admission=optional.get();
        }
        else{
            throw new RuntimeException("Admission Not Found for id !!!"+id);
        }
        return admission;
    }

    @Override
    public void deleteAdmissionById(long id) {
        admissionRepository.deleteById(id);
    }
}
