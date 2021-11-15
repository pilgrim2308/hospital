package com.example.hospital.service;

import com.example.hospital.model.BillPatient;

import java.util.List;

public interface BillPatientService {
    List<BillPatient> getAllBillPatientsByPatientId(long id);
    BillPatient save(BillPatient charge);
    BillPatient getBillPatientById(long id);
    void deleteBillPatientById(long id);
}
