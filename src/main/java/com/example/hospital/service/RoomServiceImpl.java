package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.Role;
import com.example.hospital.model.Room;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;


    public Room save(Room room) {
        return roomRepository.save(room);
    }
    
    @Override
    public List<Room> getAllRooms() {
        List<Room> list = new ArrayList<>();
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(list::add);
        return list;
    }

    @Override
    public Room getRoomById(long id) {
        Optional<Room> optional=roomRepository.findById(id);
        Room room = null;
        if(optional.isPresent()){
            room=optional.get();
        }
        else{
            throw new RuntimeException("Room Not Found for id !!!"+id);
        }
        return room;
    }

    @Override
    public void deleteRoomById(long id) {
        roomRepository.deleteById(id);
    }
}
