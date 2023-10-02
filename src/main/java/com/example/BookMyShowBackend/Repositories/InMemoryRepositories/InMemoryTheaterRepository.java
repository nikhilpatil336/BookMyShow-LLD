package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Theater;
import com.example.BookMyShowBackend.Repositories.TheaterRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTheaterRepository implements TheaterRepository {

    Map<Long, Theater> theaterMap = new HashMap<>();
    @Override
    public Theater saveTheater(Theater theater) {
        return theaterMap.put(theater.getId(), theater);
    }
}
