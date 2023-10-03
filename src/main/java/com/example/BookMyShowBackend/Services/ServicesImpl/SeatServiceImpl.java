package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Seat;
import com.example.BookMyShowBackend.Repositories.SeatRepository;
import com.example.BookMyShowBackend.Services.SeatService;
import org.springframework.stereotype.Service;

@Service
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }
    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.saveSeat(seat);
    }
}
