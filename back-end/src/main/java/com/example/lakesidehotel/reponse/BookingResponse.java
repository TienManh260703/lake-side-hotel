package com.example.lakesidehotel.reponse;

import com.example.lakesidehotel.model.Room;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    String bookingId;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    String guestFullName;
    String guestEmail;
    Integer numOfAdults;// Số lượng người lớn
    Integer numOfChildren; // Số lượng trẻ em
    Integer totalNumOfGuest;
    String bookingConfirmationCode; // Mã xác nhận đặt chỗ
    RoomResponse room;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Integer status ;

    public BookingResponse(String bookingId,
                           LocalDate checkInDate, LocalDate checkOutDate,
                           String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
