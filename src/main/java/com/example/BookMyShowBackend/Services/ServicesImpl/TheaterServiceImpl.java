package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Theater;
import com.example.BookMyShowBackend.Repositories.TheaterRepository;
import com.example.BookMyShowBackend.Services.TheaterService;
import org.springframework.stereotype.Service;

@Service
public class TheaterServiceImpl implements TheaterService {
    private TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }

    @Override
    public Theater saveTheater(Theater theater) {
        return theaterRepository.saveTheater(theater);
    }
}
