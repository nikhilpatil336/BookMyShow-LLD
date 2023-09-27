package com.example.BookMyShowBackend.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Seat extends BaseModel {

    private int seatNumber;
    private SeatType seatType;
}
