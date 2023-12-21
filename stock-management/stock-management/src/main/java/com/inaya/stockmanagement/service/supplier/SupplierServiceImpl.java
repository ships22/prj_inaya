package com.inaya.stockmanagement.service.supplier;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.model.Supplier;
import com.inaya.stockmanagement.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    /**
     * @param supplier
     * @return
     */
    @Override
    public Supplier add(Supplier supplier) throws BaseException {
        try {
        return supplierRepository.save(supplier);
        }catch (Exception e){
            throw new BaseException("Duplicate entry");
        }
    }

    /**
     * @param supplier
     * @return
     */
    @Override
    public Supplier update(Supplier supplier) {
        return supplierRepository.saveAndFlush(supplier);
    }

    /**
     * @return
     */
    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
