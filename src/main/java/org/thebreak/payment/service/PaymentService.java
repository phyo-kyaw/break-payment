package org.thebreak.payment.service;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thebreak.payment.model.Payment;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface PaymentService {
    String getToken(String customerId);
    ResponseEntity<?> makePayment(String orderId, int amount, String paymentMethodNonce, int type);
    Page<Payment> findPaymentsByType(Integer type, int page, int size);
    Page<Payment> findPaymentsByTypeAndCreatedAtBetween(Integer type, LocalDateTime start, LocalDateTime end, Integer page, Integer size);
}
