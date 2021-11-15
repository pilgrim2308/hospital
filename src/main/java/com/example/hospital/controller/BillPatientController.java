package com.example.hospital.controller;

import com.example.hospital.model.BillPatient;
import com.example.hospital.model.Charge;
import com.example.hospital.model.Item;
import com.example.hospital.repository.ItemRepository;
import com.example.hospital.service.BillPatientService;
import com.example.hospital.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class BillPatientController {
    @Autowired
    private BillPatientService billPatientService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ChargeService chargeService;

    @GetMapping("/create/billPatient")
    public String showNewBillPatientForm(Model model){
        List<Item> listItems= Collections.<Item>emptyList();
        model.addAttribute("billPatient",new BillPatient());
        List<Charge> listCharges=chargeService.getAllCharges();
        model.addAttribute("listCharges",listCharges);
        System.out.println(listCharges.size());
        return "create_billPatient";
    }

    @PostMapping("/save/billPatient")
    public String saveBillPatient(@ModelAttribute("billPatient") BillPatient billPatient,@ModelAttribute("listItems") List<Item> listItems) {
        for(Item item:listItems){
            itemRepository.save(item);
        }
        billPatient.setItems(listItems);
        billPatientService.save(billPatient);
        return "redirect:/";
    }
    @GetMapping("/update/billPatient/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        BillPatient billPatient=billPatientService.getBillPatientById(id);
        model.addAttribute("billPatient",billPatient);
        return "create_billPatient";
    }

    @GetMapping("delete/billPatient/{id}")
    public String deleteBillPatient(@PathVariable(value="id") long id){
        this.billPatientService.deleteBillPatientById(id);
        return "redirect:/";
    }
}
