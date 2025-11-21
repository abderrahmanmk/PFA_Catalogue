package com.ilyass.service_catalogue.service;

import com.ilyass.service_catalogue.domaine.entity.Category;
import com.ilyass.service_catalogue.domaine.entity.Stock;

import java.util.List;

public interface IServiceStock {
    Stock createStock(Stock stock);

    Stock getStockById(Long id);

    List<Stock> getAllStocks();

    void deleteStock(Stock stock);

    Stock updateStock(Stock stock);
}
