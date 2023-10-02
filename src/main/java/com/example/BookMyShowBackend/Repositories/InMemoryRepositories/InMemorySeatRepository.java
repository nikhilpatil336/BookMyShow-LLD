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
    public Seat save(Seat seat) {
        return seatMap.put(seat.getId(), seat);
    }
}
