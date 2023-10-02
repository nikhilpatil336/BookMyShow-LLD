package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.SeatType;
import com.example.BookMyShowBackend.Repositories.SeatTypeRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemorySeatType implements SeatTypeRepository {

    Map<Long, SeatType> seatTypeMap = new HashMap<>();
    @Override
    public SeatType save(SeatType seatType) {
        return seatTypeMap.put(seatType.getId(), seatType);
    }
}
