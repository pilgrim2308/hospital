package com.example.hospital.service;

import com.example.hospital.model.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipments();
    Equipment save(Equipment charge);
    Equipment getEquipmentById(long id);
    void deleteEquipmentById(long id);
}
