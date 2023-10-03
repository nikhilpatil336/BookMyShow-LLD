package com.example.BookMyShowBackend.Services.ServicesImpl;

import com.example.BookMyShowBackend.Model.Payment;
import com.example.BookMyShowBackend.Repositories.PaymentRepository;
import com.example.BookMyShowBackend.Services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.savePayment(payment);
    }
}
