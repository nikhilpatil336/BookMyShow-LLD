package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Show;
import com.example.BookMyShowBackend.Repositories.ShowRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryShowRepository implements ShowRepository {
    Map<Long, Show> showMap = new HashMap<>();
    @Override
    public Show saveShow(Show show) {
        return showMap.put(show.getId(), show);
    }
}
