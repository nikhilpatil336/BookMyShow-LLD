package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.Seat;
import com.example.BookMyShowBackend.Services.SeatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    public Seat saveSeat(Seat seat){
        return seatService.saveSeat(seat);
    }

}
