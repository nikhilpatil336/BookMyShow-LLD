package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.Show;
import com.example.BookMyShowBackend.Services.ShowService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    private ShowService showService;

    public ShowController(ShowService showService){
        this.showService = showService;
    }

    public Show saveShow(Show show){
        return showService.saveShow(show);
    }
}
