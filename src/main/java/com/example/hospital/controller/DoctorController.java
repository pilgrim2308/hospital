package com.example.hospital.controller;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @ModelAttribute("doctor")
    public UserRegistrationDto doctorRegistrationDto() {
        return new UserRegistrationDto();
    }

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listDoctors",doctorService.getAllDoctors());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal());
        System.out.println(auth.getName());
        return "home";
    }

    @GetMapping("/create/doctor")
    public String showNewDoctorForm(){
        return "create_doctor";
    }

    @PostMapping("/save/doctor")
    public String saveDoctor(@ModelAttribute("doctor") UserRegistrationDto registrationDto) {
        doctorService.save(registrationDto);
        return "redirect:/home/admin";
    }
    @GetMapping("/update/doctor/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        Doctor doctor=doctorService.getDoctorById(id);
        model.addAttribute("doctor",doctor);
        return "create_doctor";
    }

    @GetMapping("delete/doctor/{id}")
    public String deleteDoctor(@PathVariable(value="id") long id){
        this.doctorService.deleteDoctorById(id);
        return "redirect:/home/admin";
    }

    @GetMapping("requestAppointment")
    public String requestAppointment(Model model){
        model.addAttribute("list_doctors",doctorService.getAllDoctors());
        return "doctors-appointment";
    }
}
