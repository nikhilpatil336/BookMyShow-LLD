package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.ShowSeat;
import com.example.BookMyShowBackend.Repositories.ShowSeatRepository;
import com.example.BookMyShowBackend.Services.ShowSeatService;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }
    @Override
    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        return showSeatRepository.saveShowSeat(showSeat);
    }
}
