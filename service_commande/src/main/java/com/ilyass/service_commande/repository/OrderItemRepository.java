package com.ilyass.service_commande.repository;

import com.ilyass.service_commande.domaine.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Override
    Optional<OrderItem> findById(Long id);

    Optional<OrderItem> findByName(String name);

}