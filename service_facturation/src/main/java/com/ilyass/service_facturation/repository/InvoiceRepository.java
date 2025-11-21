package com.ilyass.service_facturation.repository;

import com.ilyass.service_facturation.domaine.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Override
    Optional<Invoice> findById(Long id);
}