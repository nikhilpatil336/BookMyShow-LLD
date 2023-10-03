package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Model.Payment;
import com.example.BookMyShowBackend.Services.PaymentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public Payment savePayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }
}
