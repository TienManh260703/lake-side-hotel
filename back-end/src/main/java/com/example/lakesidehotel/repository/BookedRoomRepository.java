package com.example.lakesidehotel.repository;

import com.example.lakesidehotel.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookedRoomRepository  extends JpaRepository<BookedRoom, String> {
}
