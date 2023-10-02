package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.DebitCard;
import com.example.BookMyShowBackend.Services.DebitCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debitcards")
public class DebitCardController {

    private DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService){
        this.debitCardService = debitCardService;
    }

    @PostMapping
    public DebitCard saveDebitCard(@RequestBody DebitCard debitCard){
        return debitCardService.save(debitCard);
    }
}
