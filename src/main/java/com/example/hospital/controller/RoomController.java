package com.example.hospital.controller;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Room;
import com.example.hospital.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/create/room")
    public String showNewRoomForm(Model model){
        model.addAttribute("room",new Room());
        return "create_room";
    }

    @PostMapping("/save/room")
    public String saveRoom(@ModelAttribute("room") Room room) {
        roomService.save(room);
        return "redirect:/home/admin";
    }
    @GetMapping("/update/room/{id}")
    public String showUpdateForm(@PathVariable(value="id") long id, Model model){
        Room room=roomService.getRoomById(id);
        model.addAttribute("room",room);
        return "create_room";
    }

    @GetMapping("delete/room/{id}")
    public String deleteRoom(@PathVariable(value="id") long id){
        this.roomService.deleteRoomById(id);
        return "redirect:/home/admin";
    }

    
}
