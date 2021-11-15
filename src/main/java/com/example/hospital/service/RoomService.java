package com.example.hospital.service;

import com.example.hospital.dto.UserRegistrationDto;
import com.example.hospital.model.Room;
import com.example.hospital.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room save(Room room);
    Room getRoomById(long id);
    void deleteRoomById(long id);
}
