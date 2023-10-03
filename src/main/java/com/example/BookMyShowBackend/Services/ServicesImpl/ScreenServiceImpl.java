package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Screen;
import com.example.BookMyShowBackend.Repositories.ScreenRepository;
import com.example.BookMyShowBackend.Services.ScreenService;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl implements ScreenService {

    private ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository){
        this.screenRepository = screenRepository;
    }
    @Override
    public Screen saveScreen(Screen screen) {
        return screenRepository.saveScreen(screen);
    }
}
