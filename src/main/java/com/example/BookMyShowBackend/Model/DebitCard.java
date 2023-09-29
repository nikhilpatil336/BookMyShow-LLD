package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.time.LocalDate;

//@AllArgsConstructor
@Getter
@Setter
@Builder
public class DebitCard extends Payment{

    private String cardNumber;
    private String cardHolderName;
    private LocalDate expiryDate;
    private int cvv;

//    public DebitCard()
//    {
//        super(PaymentType.DEBIT_CARD);
//    }
}
