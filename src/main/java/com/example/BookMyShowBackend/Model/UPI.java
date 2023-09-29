package com.example.BookMyShowBackend.Model;

import lombok.*;

//@AllArgsConstructor
@Getter
@Setter
@Builder
public class UPI extends Payment{
    private String UpiId;

//    UPI() {
//        super(PaymentType.UPI);
//    }
}
