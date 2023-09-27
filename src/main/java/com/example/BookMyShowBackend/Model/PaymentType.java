package com.example.BookMyShowBackend.Model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum PaymentType {
    CREDIT_CARD,
    DEBIT_CARD,
    UPI
}
