package com.ilyass.service_facturation.repository;

import com.ilyass.service_facturation.domaine.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Override
    Optional<Payment> findById(Long id);
}