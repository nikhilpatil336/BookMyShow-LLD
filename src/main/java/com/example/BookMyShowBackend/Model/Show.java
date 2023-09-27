package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Show extends BaseModel{

    private Movie movie;
    private Screen screen;
    private LocalTime startTime;
    private LocalTime endTime;
    private Language language;
    private List<ShowSeat> showSeats;
    private List<ShowSeatType> showSeatTypes;
}
