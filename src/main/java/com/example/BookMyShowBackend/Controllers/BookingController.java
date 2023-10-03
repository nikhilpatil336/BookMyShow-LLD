package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

//    @PostMapping()
//    public String saveBooking() {
//
//    }
}
