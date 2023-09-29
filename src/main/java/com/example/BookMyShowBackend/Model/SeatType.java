package com.example.BookMyShowBackend.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SeatType extends BaseModel {
    private Theater theater;
    private String seatType;
}
