package com.example.lakesidehotel.service.impl;

import com.example.lakesidehotel.exception.DataNotFoundException;
import com.example.lakesidehotel.mapper.RoomMapper;
import com.example.lakesidehotel.model.Room;
import com.example.lakesidehotel.reponse.RoomResponse;
import com.example.lakesidehotel.repository.RoomRepository;
import com.example.lakesidehotel.request.create.CreateRoomRequest;
import com.example.lakesidehotel.request.update.UpdateRequest;
import com.example.lakesidehotel.service.IRoomService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoomServiceImpl implements IRoomService {
    RoomRepository roomRepository;
    RoomMapper roomMapper;

    @Override
    public RoomResponse addNewRoom(MultipartFile photo, CreateRoomRequest request) throws SQLException, IOException {
        Room room = roomMapper.toCreateRoom(request);
        if (!photo.isEmpty()) {
            byte[] photoBytes = photo.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            room.setPhoto(photoBlob);
        }
        return roomMapper.toResponse(roomRepository.save(room));
    }

    @Override
    public RoomResponse updateRoom(String id, UpdateRequest request) throws DataNotFoundException {
        Room existingRoom = roomRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("Cannot find room with id : " + id)
        );
        roomMapper.toUpdateRoom(existingRoom, request);

        return roomMapper.toResponse(roomRepository.save(existingRoom));
    }

    @Override
    public List<RoomResponse> getRooms() {
        return roomRepository.findAll().stream().map(room -> roomMapper.toResponse(room)).toList();
    }

    @Override
    public RoomResponse getRoom(String id) throws DataNotFoundException {
        Room existingRoom = roomRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("Cannot find room with id : " + id)
        );
        return roomMapper.toResponse(existingRoom);
    }

    @Override
    public String delete(String id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            room.setDeleted(true);
            roomRepository.save(room);
            return "Deleted room";
        }
        return "Delete room fail";
    }

    @Override
    public List<String> getRoomType() {
        return roomRepository.findAllDistinctRoomTypes();
    }
}
