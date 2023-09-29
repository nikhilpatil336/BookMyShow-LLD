package com.example.BookMyShowBackend.MultiThreading;

import com.example.BookMyShowBackend.Model.*;
import com.example.BookMyShowBackend.Repositories.BookingRepository;
import com.example.BookMyShowBackend.Services.BookingService;

import java.util.List;
import java.util.concurrent.Callable;

public class BookingServiceRunMethod implements Callable<Booking> {

    private BookingService bookingService;
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private long id;

    public BookingServiceRunMethod(BookingService bookingService, User user, Show show, List<ShowSeat> showSeats, long id) {
        this.bookingService = bookingService;
        this.user = user;
        this.show = show;
        this.showSeats = showSeats;
        this.id = id;
    }

    @Override
    public Booking call() throws Exception {
        return bookingService.createBooking(user, show, showSeats, id);
    }
}
