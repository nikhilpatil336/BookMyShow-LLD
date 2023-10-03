package com.example.BookMyShowBackend.Controllers;


import com.example.BookMyShowBackend.Model.Screen;
import com.example.BookMyShowBackend.Services.ScreenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private ScreenService screenService;

    public ScreenController(ScreenService screenService){
        this.screenService = screenService;
    }

    public Screen saveScreen(Screen screen){
        return screenService.saveScreen(screen);
    }
}
