package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Model.CreditCard;
import com.example.BookMyShowBackend.Repositories.CreditCardRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryCreditCardRepository implements CreditCardRepository {

    Map<Long, CreditCard> creditCardMap = new HashMap<>();

    public CreditCard saveCreditCard(CreditCard creditCard){
        creditCardMap.put(creditCard.getId(), creditCard);
        return creditCardMap.get(creditCard.getId());
    }
}
