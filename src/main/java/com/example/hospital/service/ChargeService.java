package com.example.hospital.service;

import com.example.hospital.model.Charge;

import java.util.List;

public interface ChargeService {
    List<Charge> getAllCharges();
    Charge save(Charge charge);
    Charge getChargeById(long id);
    void deleteChargeById(long id);
}

