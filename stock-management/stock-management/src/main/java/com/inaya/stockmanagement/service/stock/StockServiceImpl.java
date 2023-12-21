package com.inaya.stockmanagement.service.stock;

import com.inaya.stockmanagement.model.Stock;
import com.inaya.stockmanagement.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * @param stock
     * @return
     */
    @Override
    public Stock add(Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }

    /**
     * @param stock
     * @return
     */
    @Override
    public Stock update(Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }

    /**
     * @return
     */
    @Override
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        stockRepository.deleteById(id);
    }
}
