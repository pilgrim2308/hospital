package com.example.hospital.service;

import com.example.hospital.model.Charge;
import com.example.hospital.model.Charge;
import com.example.hospital.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargeServiceImpl implements ChargeService{
    
    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public List<Charge> getAllCharges() {
        return chargeRepository.findAll();
    }

    @Override
    public Charge save(Charge charge) {
        return chargeRepository.save(charge);
    }

    @Override
    public Charge getChargeById(long id) {
        Optional<Charge> optional=chargeRepository.findById(id);
        Charge charge = null;
        if(optional.isPresent()){
            charge=optional.get();
        }
        else{
            throw new RuntimeException("Charge Not Found for id !!!"+id);
        }
        return charge;
    }   

    @Override
    public void deleteChargeById(long id) {
        chargeRepository.deleteById(id);
    }
}
