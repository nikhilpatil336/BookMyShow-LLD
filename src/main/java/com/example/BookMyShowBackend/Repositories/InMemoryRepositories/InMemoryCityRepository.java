package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Model.City;
import com.example.BookMyShowBackend.Repositories.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryCityRepository implements CityRepository {

    Map<Long, City> cityMap = new HashMap<>();

    @Override
    public City saveCity(City city) {
        cityMap.put(city.getId(), city);
        return cityMap.get(city.getId());
    }
}
