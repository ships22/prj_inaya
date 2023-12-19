package com.inaya.stockmanagement.service.supplier;

import com.inaya.stockmanagement.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    Supplier add(Supplier supplier);

    Supplier update(Supplier supplier);

    List<Supplier> getAll();

    Optional<Supplier> findById(Long id);

    void delete(Long id);

}
