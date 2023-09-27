package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Booking extends BaseModel{

    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private double price;
    private BookingStatus bookingStatus;
    private List<Payment> payments;
}
