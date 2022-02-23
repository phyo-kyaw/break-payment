package org.thebreak.payment.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.thebreak.payment.model.Payment;

import java.time.LocalDateTime;


@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Page<Payment> findPaymentsByType(int type, Pageable pageable);
    Page<Payment> findPaymentsByTypeAndCreatedAtBetween(int type, LocalDateTime start, LocalDateTime end, Pageable pageable);
}
