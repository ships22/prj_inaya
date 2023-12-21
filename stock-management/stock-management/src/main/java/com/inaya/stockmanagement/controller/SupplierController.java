package com.inaya.stockmanagement.controller;

import com.inaya.stockmanagement.dto.SupplierDTO;
import com.inaya.stockmanagement.manager.SupplierManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {
    private final SupplierManager supplierManager;

    public SupplierController(SupplierManager supplierManager) {
        this.supplierManager = supplierManager;
    }

    @PostMapping(value = "/supplier")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierManager.saveSupplier(supplierDTO);
    }

    @GetMapping
    public List<SupplierDTO> getAllSupplier() {
        return supplierManager.getAllSupplier();
    }

    @GetMapping(value = "/supplier/{id}")
    public SupplierDTO getSupplierByID(@PathVariable Long id) {
        return supplierManager.getSupplierById(id);
    }

    @PutMapping(value = "/supplier")
    public SupplierDTO updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierManager.updateSupplier(supplierDTO);
    }

    @DeleteMapping(value = "/supplier/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return supplierManager.deleteSupplier(id);
    }
}