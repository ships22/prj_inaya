package com.inaya.stockmanagement.service.stock;

import com.inaya.stockmanagement.model.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {

    Stock add(Stock stock);

    Stock update(Stock stock);

    List<Stock> getAll();

    Optional<Stock> findById(Long id);

    void delete(Long id);

}
