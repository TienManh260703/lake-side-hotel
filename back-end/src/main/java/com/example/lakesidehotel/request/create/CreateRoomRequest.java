package com.example.lakesidehotel.request.create;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateRoomRequest {
    @NotBlank(message = "Room type not blank")
    String roomType;
    @Min(value = 0 , message = "Room price min = 0")
    BigDecimal roomPrice;
}
