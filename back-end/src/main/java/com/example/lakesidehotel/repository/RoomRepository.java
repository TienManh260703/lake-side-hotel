package com.example.lakesidehotel.repository;

import com.example.lakesidehotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    @Query(value = "SELECT DISTINCT r.room_type FROM room r", nativeQuery = true)
    List<String> findAllDistinctRoomTypes();

}
