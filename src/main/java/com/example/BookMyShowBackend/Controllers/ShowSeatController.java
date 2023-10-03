package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.ShowSeat;
import com.example.BookMyShowBackend.Services.ShowSeatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showseats")
public class ShowSeatController implements ShowSeatService {

    private ShowSeatService showSeatService;

    public ShowSeatController(ShowSeatService showSeatService){
        this.showSeatService = showSeatService;
    }

    @Override
    public ShowSeat saveShowSeat(ShowSeat showSeat) {
        return showSeatService.saveShowSeat(showSeat);
    }
}
