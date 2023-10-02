package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Screen;
import com.example.BookMyShowBackend.Repositories.ScreenRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryScreenRepository implements ScreenRepository {

    Map<Long, Screen> screenMap = new HashMap<>();

    @Override
    public Screen saveScreen(Screen screen) {
        return screenMap.put(screen.getId(), screen);
    }
}
