package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.City;
import com.example.BookMyShowBackend.Repositories.CityRepository;
import com.example.BookMyShowBackend.Services.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    @Override
    public City saveCity(City city) {
        return cityRepository.saveCity(city);
    }
}
