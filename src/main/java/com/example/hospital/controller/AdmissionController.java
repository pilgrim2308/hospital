package com.example.hospital.controller;

import com.example.hospital.model.*;
import com.example.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AdmissionController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private InPatientService inPatientService;

    @Autowired
    private RoomService roomService;

    @GetMapping("createAdmissionForm/{id}")
    public String createAdmissionForm(@PathVariable long id, Model model){
        InPatient inPatient =inPatientService.getInPatientById(id);
        Admission admission=new Admission();
        model.addAttribute("patient",inPatient);
        model.addAttribute("admission",admission);
        model.addAttribute("listDoctors",doctorService.getAllDoctors());
        model.addAttribute("listRooms",roomService.getAllRooms());
        System.out.println(doctorService.getAllDoctors().size());
        System.out.println(roomService.getAllRooms().size());
        return "admission_form";
    }

    @PostMapping("/createAdmission/{id}")
    public String createAdmission(@RequestParam("doctor") String doctorId, @RequestParam("room") String roomId, @ModelAttribute("admission")Admission admission, @PathVariable long id, Model model){
        Doctor doctor=doctorService.getDoctorById(Long.parseLong(doctorId));
        Room room=roomService.getRoomById(Long.parseLong(roomId));
        InPatient inPatient =inPatientService.getInPatientById(id);
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        admission.setPatient(inPatient);
        admission.setStatus("ADMITTED");
        admission.setAdmission_date(date);
        admission.setDoctor(doctor);
        admission.setRoom(room);
        admissionService.save(admission);
        return "redirect:/";
    }

    @GetMapping("/view/admission/{id}")
    public String viewAdmission(@PathVariable long id,Model model){
        Admission admission=admissionService.getAdmissionById(id);
        Doctor doctor=admission.getDoctor();
        Date date = (Date) admission.getAdmission_date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        InPatient inPatient=admission.getPatient();
        Room room=admission.getRoom();
        model.addAttribute("room",room);
        model.addAttribute("admission",admission);
        model.addAttribute("doctor",doctor);
        model.addAttribute("patient",inPatient);
        model.addAttribute("date",strDate);
        return "view_admission";
    }

    @GetMapping("/view/admissionList")
    public String viewAdmissionList(Model model){
        List<Admission> listAdmission=admissionService.getAllByStatus("ADMITTED");
        model.addAttribute("listAdmissions",listAdmission);
        return "list_admissions";
    }
}