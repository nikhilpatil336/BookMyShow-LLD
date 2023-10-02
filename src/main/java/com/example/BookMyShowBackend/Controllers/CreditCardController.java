package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.CreditCard;
import com.example.BookMyShowBackend.Services.CreditCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {

    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService){
        this.creditCardService = creditCardService;
    }

    @PostMapping()
    public CreditCard saveCreditCard(@RequestBody CreditCard creditCard){
        return creditCardService.save(creditCard);
    }
}
