package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Seat;
import com.example.BookMyShowBackend.Repositories.SeatRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemorySeatRepository implements SeatRepository {

    Map<Long, Seat> seatMap = new HashMap<>();
    @Override
    public Seat saveSeat(Seat seat) {
        seatMap.put(seat.getId(), seat);
        return seatMap.get(seat.getId());
    }
}
