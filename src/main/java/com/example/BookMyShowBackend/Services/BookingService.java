package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Model.Booking;
import com.example.BookMyShowBackend.Model.Show;
import com.example.BookMyShowBackend.Model.ShowSeat;
import com.example.BookMyShowBackend.Model.User;

import java.util.List;

public interface BookingService {

    Booking createBooking(User user, Show show, List<ShowSeat> showSeats, long l);
}
