package com.example.BookMyShowBackend.Model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public abstract class Payment extends BaseModel{

    private User user;
    private LocalDateTime dateAndTime;
    private double amount;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;

    Payment(PaymentType paymentType){
        this.paymentType = paymentType;
    }
}
