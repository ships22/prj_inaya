package com.inaya.stockmanagement.service.depot;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.model.Depot;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface DepotService {
    Depot add(Depot depot) throws BaseException;

    Depot update(Depot depot);

    List<Depot> getAll();

    Optional<Depot> findById(Long id);

    void delete(Long id);
}
