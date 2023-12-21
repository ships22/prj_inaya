package com.inaya.stockmanagement.service.supplier;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.model.Supplier;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

public interface SupplierService {

    Supplier add(Supplier supplier) throws BaseException;

    Supplier update(Supplier supplier);

    List<Supplier> getAll();

    Optional<Supplier> findById(Long id);

    void delete(Long id);

}
