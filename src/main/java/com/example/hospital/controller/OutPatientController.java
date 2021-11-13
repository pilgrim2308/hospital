package com.example.hospital.controller;

import com.example.hospital.dto.PatientRegistrationDto;
import com.example.hospital.model.OutPatient;
import com.example.hospital.service.OutPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OutPatientController {
    @Autowired
    private OutPatientService outPatientService;

    @ModelAttribute("outPatient")
    public PatientRegistrationDto outPatientRegistrationDto() {
        return new PatientRegistrationDto();
    }

    public OutPatientController(OutPatientService outPatientService) {
        this.outPatientService = outPatientService;
    }

    @GetMapping("/create/outPatient")
    public String showNewOutPatientForm(){
        return "create_outpatient";
    }

    @PostMapping("/save/outPatient")
    public String saveOutPatient(@ModelAttribute("outPatient") PatientRegistrationDto registrationDto) {
        outPatientService.save(registrationDto);
        return "redirect:/";
    }
    @GetMapping("/update/outPatient/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        OutPatient outPatient=outPatientService.getOutPatientById(id);
        model.addAttribute("outPatient",outPatient);
        return "create_outpatient";
    }

    @GetMapping("delete/outPatient/{id}")
    public String deleteOutPatient(@PathVariable(value="id") long id){
        this.outPatientService.deleteOutPatientById(id);
        return "redirect:/";
    }
}
