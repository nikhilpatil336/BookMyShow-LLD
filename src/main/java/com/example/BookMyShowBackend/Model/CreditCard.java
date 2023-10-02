package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreditCard extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expiryDate;
    private int cvv;

    CreditCard() {
        super(PaymentType.CREDIT_CARD);
    }
}
