package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.CreditCard;
import com.example.BookMyShowBackend.Repositories.CreditCardRepository;
import com.example.BookMyShowBackend.Services.CreditCardService;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard save(CreditCard creditCard) {
        return creditCardRepository.saveCreditCard(creditCard);
    }
}
