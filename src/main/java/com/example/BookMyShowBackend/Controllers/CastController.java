package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Services.CastService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casts")
public class CastController {

    private CastService castService;

    public CastController(CastService castService){
        this.castService = castService;
    }

    @PostMapping()
    public Cast saveCast(@RequestBody Cast cast){
        return castService.saveCast(cast);
    }
}
