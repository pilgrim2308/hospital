package com.example.hospital.service;

import com.example.hospital.model.BillPatient;
import com.example.hospital.model.Charge;
import com.example.hospital.repository.BIllPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillPatientServiceImpl implements BillPatientService{

    
    @Autowired
    private BIllPatientRepository billPatientRepository;

    @Override
    public List<BillPatient> getAllBillPatientsByPatientId(long id) {
        return billPatientRepository.getAllByInPatient_Id(id);
    }

    @Override
    public BillPatient save(BillPatient billPatient) {
        return billPatientRepository.save(billPatient);
    }

    @Override
    public BillPatient getBillPatientById(long id) {
        Optional<BillPatient> optional=billPatientRepository.findById(id);
        BillPatient billPatient = null;
        if(optional.isPresent()){
            billPatient=optional.get();
        }
        else{
            throw new RuntimeException("BillPatient Not Found for id !!!"+id);
        }
        return billPatient;
    }

    @Override
    public void deleteBillPatientById(long id) {
        billPatientRepository.deleteById(id);
    }
}
