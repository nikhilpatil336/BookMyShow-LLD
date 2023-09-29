package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.ShowSeat;
import com.example.BookMyShowBackend.Repositories.ShowSeatRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryShowSeatRepository implements ShowSeatRepository {

    private Map<Long, ShowSeat> showSeatsMap = new HashMap<>();

    @Override
    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        return showSeatsMap.put(showSeat.getId(), showSeat);
    }

    @Override
    public ShowSeat updateShowSeat(ShowSeat showSeat) {
        return showSeatsMap.put(showSeat.getId(), showSeat);
    }
}
