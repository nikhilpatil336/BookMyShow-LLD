package com.example.BookMyShowBackend.Repositories.InMemoryRepositories;

import com.example.BookMyShowBackend.Model.Cast;
import com.example.BookMyShowBackend.Model.Payment;
import com.example.BookMyShowBackend.Repositories.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class InMemoryPaymentRepository implements PaymentRepository {

    Map<Long, Payment> paymentMap = new HashMap<>();

    @Override
    public Payment savePayment(Payment payment) {
        paymentMap.put(payment.getId(), payment);
        return paymentMap.get(payment.getId());
    }
}
