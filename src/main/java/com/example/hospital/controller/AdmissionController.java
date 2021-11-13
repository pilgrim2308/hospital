package com.example.hospital.controller;

import com.example.hospital.model.Admission;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.InPatient;
import com.example.hospital.model.OutPatient;
import com.example.hospital.service.AdmissionService;
import com.example.hospital.service.DoctorService;
import com.example.hospital.service.InPatientService;
import com.example.hospital.service.OutPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
public class AdmissionController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private InPatientService inPatientService;

    @Autowired
    private RoomService roomService;

    @GetMapping("createAdmissionForm/{id}")
    public String createAdmissionForm(@PathVariable long id, Model model){
        InPatient inPatient =inPatientService.getInPatientById(id);
        Admission admission=new Admission();
        model.addAttribute("patient",inPatient);
        model.addAttribute("admission",admission);
        model.addAttribute("listDoctors",doctorService.getAllDoctors());
        return "admission_form";
    }

    @PostMapping("/createAdmission/{id}")
    public String createAdmission(@ModelAttribute("admission")Admission admission, @PathVariable long id, Model model){
        InPatient inPatient =inPatientService.getInPatientById(id);
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        admission.setPatient(inPatient);
        admission.setStatus("ADMITTED");
        admission.setAdmission_date(date);
        admissionService.save(admission);
        return "redirect:/";
    }
}