package com.example.BookMyShowBackend.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShowSeatType extends BaseModel {
    private Show show;
    private SeatType seatType;
    private double price;
}
