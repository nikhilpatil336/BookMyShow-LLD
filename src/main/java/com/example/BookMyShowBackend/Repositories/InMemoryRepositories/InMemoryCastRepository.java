package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Repositories.CastRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryCastRepository implements CastRepository {

    Map<Long, Cast> castMap = new HashMap<>();

    @Override
    public Cast saveCast(Cast cast) {
        castMap.put(cast.getId(), cast);
        return castMap.get(cast.getId());
    }
}
