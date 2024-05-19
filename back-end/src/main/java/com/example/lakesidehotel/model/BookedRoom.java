package com.example.lakesidehotel.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "booked_room")
public class BookedRoom {
    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    String bookingId;
    @Column(name = "check_in")
    LocalDate checkInDate;
    @Column(name = "check_out")
    LocalDate checkOutDate;
    @Column(name = "guest_full_name")
    String guestFullName;
    @Column(name ="guest_email")
    String guestEmail;
    @Column(name ="num_of_adults")
    Integer numOfAdults;// Số lượng người lớn
    @Column(name ="num_of_children")
    Integer numOfChildren; // Số lượng trẻ em
    @Column(name ="total_num_of_guest")
    Integer totalNumOfGuest;
    @Column(name ="booking_confirmation_code")
    String bookingConfirmationCode; // Mã xác nhận đặt chỗ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    Room room;
    @Column(name = "created_at")
    LocalDateTime createdAt;
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
    Integer status=0;

    public void calculateTotalNumberOfGuest() {
        this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfAdults(Integer numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(Integer numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
