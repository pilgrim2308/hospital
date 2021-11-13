package com.example.hospital.controller;

import com.example.hospital.model.Appointment;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.OutPatient;
import com.example.hospital.service.AppointmentService;
import com.example.hospital.service.DoctorService;
import com.example.hospital.service.OutPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@Controller
public class AppointmentController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private OutPatientService outPatientService;

    @GetMapping("requestAppointment/{id}")
    public String requestAppointment(@PathVariable long id, Model model){
        Appointment appointment=new Appointment();
        Doctor doctor=doctorService.getDoctorById(id);
        model.addAttribute("Doctor",doctor);
        model.addAttribute("appointment",appointment);
        return "appointment_form";
    }

    @PostMapping("/requestAppointment/{id}")
    public String submitRequestAppointment(/*@RequestParam("time") Time time,*/ @RequestParam("date") Date date, @ModelAttribute("appointment")Appointment appointment, @PathVariable long id, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        OutPatient outPatient=outPatientService.getOutPatientByEmail(email);
        Doctor doctor=doctorService.getDoctorById(id);
        model.addAttribute("doctor",doctor);
        appointment.setDoctor(doctor);
        appointment.setPatient(outPatient);
        appointment.setStatus("REQUEST PENDING");
//        appointment.setAppointment_time(time);
        appointment.setAppointment_date(date);
        appointmentService.save(appointment);
        return "redirect:/";
    }
}
