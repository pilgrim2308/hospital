package com.example.hospital.controller;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.InPatient;
import com.example.hospital.service.InPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InPatientController {
    @Autowired
    private InPatientService inPatientService;

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
}
