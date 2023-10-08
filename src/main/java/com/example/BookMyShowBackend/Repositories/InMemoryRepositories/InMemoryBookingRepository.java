package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Booking;
import com.example.BookMyShowBackend.Repositories.BookingRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookingRepository implements BookingRepository {
    Map<Long, Booking> bookingMap = new HashMap<>();
    @Override
    public Booking saveBooking(Booking booking) {
        bookingMap.put(booking.getId(), booking);
        return bookingMap.get(booking.getId());
    }
}