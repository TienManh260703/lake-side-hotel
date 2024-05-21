package com.example.lakesidehotel.service;

import com.example.lakesidehotel.exception.DataNotFoundException;
import com.example.lakesidehotel.model.Room;
import com.example.lakesidehotel.reponse.RoomResponse;
import com.example.lakesidehotel.request.create.CreateRoomRequest;
import com.example.lakesidehotel.request.update.UpdateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IRoomService {
    RoomResponse addNewRoom(MultipartFile  photo, CreateRoomRequest request) throws SQLException, IOException;

    RoomResponse updateRoom (String id , UpdateRequest request) throws DataNotFoundException;
    List<RoomResponse> getRooms ();
    RoomResponse getRoom (String id) throws DataNotFoundException;
    String delete (String id);
    List<String>  getRoomType ();
}
