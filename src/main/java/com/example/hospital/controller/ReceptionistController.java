package com.example.hospital.controller;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Receptionist;
import com.example.hospital.service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;

    @ModelAttribute("receptionist")
    public UserRegistrationDto receptionistRegistrationDto() {
        return new UserRegistrationDto();
    }

    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }



    @GetMapping("/create/receptionist")
    public String showNewReceptionistForm(){
        return "create_receptionist";
    }

    @PostMapping("/save/receptionist")
    public String saveReceptionist(@ModelAttribute("receptionist") UserRegistrationDto registrationDto) {
        receptionistService.save(registrationDto);
        return "redirect:/home/admin";
    }
    @GetMapping("/update/receptionist/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        Receptionist receptionist=receptionistService.getReceptionistById(id);
        model.addAttribute("receptionist",receptionist);
        return "create_receptionist";
    }

    @GetMapping("delete/receptionist/{id}")
    public String deleteReceptionist(@PathVariable(value="id") long id){
        this.receptionistService.deleteReceptionistById(id);
        return "redirect:/home/admin";
    }
}
