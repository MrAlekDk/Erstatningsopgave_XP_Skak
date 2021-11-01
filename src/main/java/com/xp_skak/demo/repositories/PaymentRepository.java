package com.xp_skak.demo.repositories;

import com.xp_skak.demo.models.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PaymentRepository extends CrudRepository<Payment,Long> {

    //@Query(value = "SELECT * FROM Payment WHERE lastPaymentDate < current_date")
    //Collection<Payment> findAllPaymentsInDebt();
}
