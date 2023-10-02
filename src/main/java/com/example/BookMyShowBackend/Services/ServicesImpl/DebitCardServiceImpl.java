package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.DebitCard;
import com.example.BookMyShowBackend.Repositories.DebitCardRepository;
import com.example.BookMyShowBackend.Services.DebitCardService;
import org.springframework.stereotype.Service;

@Service
public class DebitCardServiceImpl implements DebitCardService {

    private DebitCardRepository debitCardRepository;
    @Override
    public DebitCard save(DebitCard debitCard) {
        return debitCardRepository.saveDebitCard(debitCard);
    }
}
