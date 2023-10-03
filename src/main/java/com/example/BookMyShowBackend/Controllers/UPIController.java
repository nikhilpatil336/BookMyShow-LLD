package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.UPI;
import com.example.BookMyShowBackend.Services.UPIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upi")
public class UPIController {

    private UPIService upiService;

    public UPIController(UPIService upiService){
        this.upiService = upiService;
    }

    public UPI saveUPI(UPI upi){
        return upiService.saveUPI(upi);
    }
}
