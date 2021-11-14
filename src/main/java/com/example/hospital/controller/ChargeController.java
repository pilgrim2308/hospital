package com.example.hospital.controller;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Charge;
import com.example.hospital.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChargeController {
    @Autowired
    private ChargeService chargeService;

    @GetMapping("/create/charge")
    public String showNewChargeForm(Model model){
        model.addAttribute("charge",new Charge());
        return "create_charge";
    }

    @PostMapping("/save/charge")
    public String saveCharge(@ModelAttribute("charge") Charge charge) {
        chargeService.save(charge);
        return "redirect:/";
    }
    @GetMapping("/update/charge/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        Charge charge=chargeService.getChargeById(id);
        model.addAttribute("charge",charge);
        return "create_charge";
    }

    @GetMapping("delete/charge/{id}")
    public String deleteCharge(@PathVariable(value="id") long id){
        this.chargeService.deleteChargeById(id);
        return "redirect:/";
    }
}
