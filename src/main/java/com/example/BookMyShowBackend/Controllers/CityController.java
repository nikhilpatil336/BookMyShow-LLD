package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.City;
import com.example.BookMyShowBackend.Services.CityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @PostMapping()
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }
}
