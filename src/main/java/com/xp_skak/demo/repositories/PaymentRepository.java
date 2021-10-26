package com.xp_skak.demo.repositories;

import com.xp_skak.demo.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Long> {
}
