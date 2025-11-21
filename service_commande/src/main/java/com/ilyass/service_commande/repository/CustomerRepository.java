package com.ilyass.service_commande.repository;

import com.ilyass.service_commande.domaine.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    Optional<Customer> findById(Long id);

    Optional<Customer> findByName(String name);

    Optional<Customer> findByEmail(String email);
}