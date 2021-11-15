package com.example.hospital.service;

import com.example.hospital.model.Equipment;
import com.example.hospital.repository.EquipmentRepository;
import com.example.hospital.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService{
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Override
    public List<Equipment> getAllEquipments() {
        return equipmentRepository.findAll();
    }
    @Override
    public Equipment save(Equipment equipment) {
        equipment.setAvailable_quantity(equipment.getTotal_quantity());
        return equipmentRepository.save(equipment);
    }
    @Override
    public Equipment getEquipmentById(long id) {
        Optional<Equipment> optional=equipmentRepository.findById(id);
        Equipment equipment = null;
        if(optional.isPresent()){
            equipment=optional.get();
        }
        else{
            throw new RuntimeException("Equipment Not Found for id !!!"+id);
        }
        return equipment;
    }
    @Override
    public void deleteEquipmentById(long id) {
        equipmentRepository.deleteById(id);
    }
}
