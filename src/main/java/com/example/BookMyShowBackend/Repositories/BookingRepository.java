package com.example.BookMyShowBackend.Repositories;

import com.example.BookMyShowBackend.Model.Booking;
import com.example.BookMyShowBackend.Model.ShowSeat;

import java.util.List;

public interface BookingRepository {

    Booking saveBooking(Booking booking);

    boolean lockShowSeat(Long id);

    boolean unlockShowSeat(List<Long> ids);
}
