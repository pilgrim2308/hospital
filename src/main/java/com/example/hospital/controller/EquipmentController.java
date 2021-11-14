package com.example.hospital.controller;

import com.example.hospital.model.Equipment;
import com.example.hospital.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/create/equipment")
    public String showNewEquipmentForm(Model model){
        model.addAttribute("equipment",new Equipment());
        return "create_equipment";
    }

    @PostMapping("/save/equipment")
    public String saveEquipment(@ModelAttribute("equipment") Equipment equipment) {
        equipmentService.save(equipment);
        return "redirect:/";
    }
    @GetMapping("/update/equipment/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        Equipment equipment=equipmentService.getEquipmentById(id);
        model.addAttribute("equipment",equipment);
        return "create_equipment";
    }

    @GetMapping("delete/equipment/{id}")
    public String deleteEquipment(@PathVariable(value="id") long id){
        this.equipmentService.deleteEquipmentById(id);
        return "redirect:/";
    }
}
