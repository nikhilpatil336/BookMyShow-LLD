package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Show;
import com.example.BookMyShowBackend.Repositories.ShowRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryShowRepository implements ShowRepository {
    Map<Long, Show> showMap = new HashMap<>();
    @Override
    public Show saveShow(Show show) {
        showMap.put(show.getId(), show);
        return showMap.get(show.getId());
    }
}
