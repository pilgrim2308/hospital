package com.example.hospital.controller;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Nurse;
import com.example.hospital.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NurseController {
    @Autowired
    private NurseService nurseService;

    @ModelAttribute("nurse")
    public UserRegistrationDto nurseRegistrationDto() {
        return new UserRegistrationDto();
    }

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping("/create/nurse")
    public String showNewNurseForm(){
        return "create_nurse";
    }

    @PostMapping("/save/nurse")
    public String saveNurse(@ModelAttribute("nurse") UserRegistrationDto registrationDto) {
        nurseService.save(registrationDto);
        return "redirect:/home/admin";
    }
    @GetMapping("/update/nurse/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        Nurse nurse=nurseService.getNurseById(id);
        model.addAttribute("nurse",nurse);
        return "create_nurse";
    }

    @GetMapping("delete/nurse/{id}")
    public String deleteNurse(@PathVariable(value="id") long id){
        this.nurseService.deleteNurseById(id);
        return "redirect:/home/admin";
    }
}
