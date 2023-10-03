package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.Theater;
import com.example.BookMyShowBackend.Services.TheaterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    private TheaterService theaterService;

    public TheaterController(TheaterService theaterService){
        this.theaterService = theaterService;
    }

    public Theater saveTheater(Theater theater){
        return theaterService.saveTheater(theater);
    }
}
