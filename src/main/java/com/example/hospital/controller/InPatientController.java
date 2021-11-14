package com.example.hospital.controller;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.model.Admission;
import com.example.hospital.model.Appointment;
import com.example.hospital.model.InPatient;
import com.example.hospital.model.OutPatient;
import com.example.hospital.service.AdmissionService;
import com.example.hospital.service.AppointmentService;
import com.example.hospital.service.InPatientService;
import com.example.hospital.service.OutPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class InPatientController {
    @Autowired
    private InPatientService inPatientService;

    @Autowired
    private OutPatientService outPatientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AdmissionService admissionService;

    @ModelAttribute("inPatient")
    public PatientRegistrationDto inPatientRegistrationDto() {
        return new PatientRegistrationDto();
    }

    public InPatientController(InPatientService inPatientService) {
        this.inPatientService = inPatientService;
    }
    
    @GetMapping("/create/inPatient")
    public String showNewInPatientForm(){
        return "create_inpatient";
    }

    @PostMapping("/save/inPatient")
    public String saveInPatient(@ModelAttribute("inPatient") PatientRegistrationDto registrationDto) {
        inPatientService.save(registrationDto);
        return "redirect:/";
    }
    @GetMapping("/update/inPatient/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        InPatient inPatient=inPatientService.getInPatientById(id);
        model.addAttribute("inPatient",inPatient);
        return "create_inpatient";
    }

    @GetMapping("delete/inPatient/{id}")
    public String deleteInPatient(@PathVariable(value="id") long id){
        this.inPatientService.deleteInPatientById(id);
        return "redirect:/";
    }

    @GetMapping("view/inPatient/{id}")
    public String viewInPatient(@PathVariable long id,Model model){
        InPatient inPatient=inPatientService.getInPatientById(id);
        String email=inPatient.getEmail();
        OutPatient outpatient=outPatientService.getOutPatientByEmail(email);
        List<Appointment> appointments= Collections.emptyList();
        if(outpatient!=null){
            long patientId=outpatient.getId();
            appointments=appointmentService.getAllByPatientId(patientId);
        }
        List<Admission> admissions=admissionService.getAllByPatientId(id);
        model.addAttribute("admissions",admissions);
        model.addAttribute("appointments",appointments);
        model.addAttribute("inPatient",inPatient);
        return "patient_by_patient";
    }
}
