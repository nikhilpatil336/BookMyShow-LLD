package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Theater;
import com.example.BookMyShowBackend.Repositories.TheaterRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryTheaterRepository implements TheaterRepository {

    Map<Long, Theater> theaterMap = new HashMap<>();
    @Override
    public Theater saveTheater(Theater theater) {
        theaterMap.put(theater.getId(), theater);
        return theaterMap.get(theater.getId());
    }
}
