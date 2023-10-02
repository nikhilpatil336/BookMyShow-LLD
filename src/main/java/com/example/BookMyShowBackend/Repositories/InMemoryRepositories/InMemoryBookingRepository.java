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
    Map<Long, Booking> bookingMap = new ConcurrentHashMap<>();
    Map<Long, Integer> lockShowSeatMap = new ConcurrentHashMap<>();
    @Override
    public Booking saveBooking(Booking booking) {
        bookingMap.put(booking.getId(), booking);
        return bookingMap.get(booking.getId());
    }

    @Override
    public boolean lockShowSeat(Long id) {
        if(lockShowSeatMap.containsKey(id))
        {
            if (lockShowSeatMap.get(id)!= 0)
                return false;
            else if(lockShowSeatMap.get(id) == 0) {
                lockShowSeatMap.put(id, 1);
                return true;
            }
        }
        else
        {
            lockShowSeatMap.put(id, 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean unlockShowSeat(List<Long> ids) {
        for(Long id : ids)
        {
            lockShowSeatMap.put(id, 0);
        }
        return true;
    }
}