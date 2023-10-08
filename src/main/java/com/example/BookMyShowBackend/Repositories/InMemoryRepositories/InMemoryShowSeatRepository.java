package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.ShowSeat;
import com.example.BookMyShowBackend.Repositories.ShowSeatRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryShowSeatRepository implements ShowSeatRepository {

    private Map<Long, ShowSeat> showSeatsMap = new ConcurrentHashMap<>();

    private Map<Long, Integer> lockShowSeatMap = new ConcurrentHashMap<>();

    @Override
    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        showSeatsMap.put(showSeat.getId(), showSeat);
        return showSeatsMap.get(showSeat.getId());
    }

    @Override
    public ShowSeat updateShowSeat(ShowSeat showSeat) {
        showSeatsMap.put(showSeat.getId(), showSeat);
        return showSeatsMap.get(showSeat.getId());
    }

    @Override
    public ShowSeat getShowSeatById(Long currentshowSeatId) {
        if (showSeatsMap.containsKey(currentshowSeatId))
            return showSeatsMap.get(currentshowSeatId);
        else
            throw new RuntimeException("Show Seat does not exist.");
    }

    @Override
    public List<ShowSeat> getAllShowSeats() {
        return new ArrayList<>(showSeatsMap.values());
    }

    @Override
    public boolean getLockOverShowSeats(Long showSeatId) {

        ShowSeat currentShowSeat = showSeatsMap.get(showSeatId);

        synchronized (showSeatId)
        {
            if(lockShowSeatMap.containsKey(showSeatId))
            {
                if(lockShowSeatMap.get(showSeatId) == 1)
                    return false;
                else
                {
                    lockShowSeatMap.put(showSeatId, 1);
                    return true;
                }
            }
            lockShowSeatMap.put(showSeatId, 1);
            return true;
        }
    }

    @Override
    public boolean unlockShowSeats(Long showSeatId) {
        synchronized (showSeatId) {
            lockShowSeatMap.put(showSeatId, 0);
        }
        return true;
    }
}
