package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.ShowSeatType;
import com.example.BookMyShowBackend.Services.ShowSeatTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showseattypes")
public class ShowSeatTypeController {

    private ShowSeatTypeService showSeatTypeService;

    ShowSeatTypeController(ShowSeatTypeService showSeatTypeService){
        this.showSeatTypeService = showSeatTypeService;
    }

    public ShowSeatType saveSeatType(ShowSeatType seatType){
        return showSeatTypeService.saveShowSeatType(seatType);
    }
}
