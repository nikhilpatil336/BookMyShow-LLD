package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.ShowSeat;
import com.example.BookMyShowBackend.Repositories.ShowSeatRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
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

    @Override
    public ShowSeat getShowSeatById(Long currentshowSeatId) {
        return showSeatsMap.get(currentshowSeatId);
    }

    @Override
    public List<ShowSeat> getAllShowSeats() {
        return new ArrayList<>(showSeatsMap.values());
    }
}
