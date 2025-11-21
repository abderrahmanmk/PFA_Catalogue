package com.ilyass.service_catalogue.service.impl;

import com.ilyass.service_catalogue.domaine.entity.Stock;
import com.ilyass.service_catalogue.repository.StockRepository;
import com.ilyass.service_catalogue.service.IServiceStock;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceStockImpl implements IServiceStock {
    private final StockRepository stockRepository;

    @Autowired
    public ServiceStockImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock) {
        if (stockRepository.existsById(stock.getId())) {
            Stock oldStock = stockRepository.findById(stock.getId()).get();
            oldStock.setProduct(stock.getProduct());
            oldStock.setQuantity(stock.getQuantity());
            return stockRepository.save(oldStock);
        } else throw new EntityNotFoundException("Stock not found" + stock.getId());
    }

    @Override
    public void deleteStock(Stock stock) {
        if (stockRepository.existsById(stock.getId())) {
            stockRepository.deleteById(stock.getId());
        } else throw new EntityNotFoundException("Role not found" + stock.getId());
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new
                EntityNotFoundException("Stock not found" + id));
    }

}
