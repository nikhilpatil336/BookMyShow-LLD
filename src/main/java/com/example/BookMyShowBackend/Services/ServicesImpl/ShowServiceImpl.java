package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Show;
import com.example.BookMyShowBackend.Repositories.ShowRepository;
import com.example.BookMyShowBackend.Services.ShowService;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImpl implements ShowService {

    private ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository){
        this.showRepository = showRepository;
    }
    @Override
    public Show saveShow(Show show) {
        return showRepository.saveShow(show);
    }
}
