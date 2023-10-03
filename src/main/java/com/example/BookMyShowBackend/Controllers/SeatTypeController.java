package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.SeatType;
import com.example.BookMyShowBackend.Services.SeatTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seattypes")
public class SeatTypeController {

    private SeatTypeService seatTypeService;

    public SeatTypeController(SeatTypeService seatTypeService){
        this.seatTypeService = seatTypeService;
    }

    public SeatType saveSeatType(SeatType seatType){
        return seatTypeService.saveSeatType(seatType);
    }
}
