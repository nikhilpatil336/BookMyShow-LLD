package com.example.BookMyShowBackend.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SeatType {
    private Theater theater;
    private String seatType;
}
