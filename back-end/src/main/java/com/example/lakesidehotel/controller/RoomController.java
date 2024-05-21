package com.example.lakesidehotel.controller;

import com.example.lakesidehotel.reponse.RoomResponse;
import com.example.lakesidehotel.request.create.CreateRoomRequest;
import com.example.lakesidehotel.service.IRoomService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin
public class RoomController {
    IRoomService roomService;

    @PostMapping(value = "add/new-room", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @Valid @RequestBody CreateRoomRequest request,
            BindingResult result) throws IOException, SQLException {
        System.err.println("Vao ");
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Lỗi: " + result.getAllErrors());
        }
        return ResponseEntity.ok().body(roomService.addNewRoom(photo, request));
    }

    @GetMapping("room-types")
    public ResponseEntity<?> roomTypes (){
        return ResponseEntity.ok().body(roomService.getRoomType());
    }
}
