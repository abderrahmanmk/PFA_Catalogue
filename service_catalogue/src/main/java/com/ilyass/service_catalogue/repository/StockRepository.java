package com.ilyass.service_catalogue.repository;

import com.ilyass.service_catalogue.domaine.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Override
    Optional<Stock> findById(Long aLong);
}