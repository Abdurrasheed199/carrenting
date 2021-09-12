package com.rent.carrenting.repository;

import com.rent.carrenting.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
