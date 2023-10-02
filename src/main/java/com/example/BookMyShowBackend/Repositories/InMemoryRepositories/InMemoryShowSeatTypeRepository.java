package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.ShowSeatType;
import com.example.BookMyShowBackend.Repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryShowSeatTypeRepository implements ShowSeatTypeRepository {

    Map<Long, ShowSeatType> seatTypeMap = new HashMap<>();
    @Override
    public ShowSeatType save(ShowSeatType showSeatType) {
        return seatTypeMap.put(showSeatType.getId(), showSeatType);
    }
}
