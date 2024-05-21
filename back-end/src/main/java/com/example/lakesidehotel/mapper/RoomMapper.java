package com.example.lakesidehotel.mapper;

import com.example.lakesidehotel.model.Room;
import com.example.lakesidehotel.reponse.RoomResponse;
import com.example.lakesidehotel.request.create.CreateRoomRequest;
import com.example.lakesidehotel.request.update.UpdateRequest;
import org.springframework.stereotype.Component;

import java.net.CacheRequest;

@Component
public class RoomMapper {
    public RoomResponse toResponse(Room room) {
        return RoomResponse.builder()
                .id(room.getId())
                .roomType(room.getRoomType())
                .roomPrice(room.getRoomPrice())
                .build();
    }

    public Room toCreateRoom(CreateRoomRequest request) {
        return Room.builder()
                .roomType(request.getRoomType())
                .roomPrice(request.getRoomPrice())
                .build();
    }

    public void toUpdateRoom(Room room, UpdateRequest request) {
        room.setRoomPrice(request.getRoomPrice());
        room.setRoomType(request.getRoomType());
    }
}
