package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Model.DebitCard;
import com.example.BookMyShowBackend.Repositories.DebitCardRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryDebitCardRepository implements DebitCardRepository {
    Map<Long, DebitCard> debitCardMap = new HashMap<>();

    @Override
    public DebitCard saveDebitCard(DebitCard debitCard) {
        debitCardMap.put(debitCard.getId(), debitCard);
        return debitCardMap.get(debitCard.getId());
    }
}
