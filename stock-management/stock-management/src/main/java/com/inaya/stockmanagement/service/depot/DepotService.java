package com.inaya.stockmanagement.service.depot;

import com.inaya.stockmanagement.model.Depot;

import java.util.List;
import java.util.Optional;

public interface DepotService {
    Depot add(Depot depot);

    Depot update(Depot depot);

    List<Depot> getAll();

    Optional<Depot> findById(Long id);

    void delete(Long id);
}
