package com.example.lakesidehotel.reponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    String id;
    String roomType;
    BigDecimal roomPrice;
    Boolean isBooked;
    String photo;
    List<BookingResponse> bookings;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public RoomResponse(String id, String roomType, BigDecimal roomPrice, Boolean isBooked) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
    }

    public RoomResponse(
            String id, String roomType, BigDecimal roomPrice, Boolean isBooked,
            byte[] photoBytes, List<BookingResponse> bookings, LocalDateTime createdAt,
            LocalDateTime updatedAt) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes) : null;
        this.bookings = bookings;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
