package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Seat;
import com.example.BookMyShowBackend.Model.SeatType;
import com.example.BookMyShowBackend.Repositories.SeatTypeRepository;
import com.example.BookMyShowBackend.Services.SeatTypeService;
import org.springframework.stereotype.Service;

@Service
public class SeatTypeServiceImpl implements SeatTypeService {

    private SeatTypeRepository seatTypeRepository;

    public SeatTypeServiceImpl(SeatTypeRepository seatTypeRepository) {
        this.seatTypeRepository = seatTypeRepository;
    }

    @Override
    public SeatType saveSeatType(SeatType seatType) {
        return seatTypeRepository.saveSeatType(seatType);
    }
}
