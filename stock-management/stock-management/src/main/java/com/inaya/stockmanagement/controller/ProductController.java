package com.inaya.stockmanagement.controller;

import com.inaya.stockmanagement.dto.CategoryDTO;
import com.inaya.stockmanagement.dto.ProductReqDTO;
import com.inaya.stockmanagement.dto.ProductResDTO;
import com.inaya.stockmanagement.manager.ProductManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/v1/api/products")
public class ProductController {

    private final ProductManager productManager;

    public ProductController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @PostMapping(value = "/product")
    public ResponseEntity<ProductResDTO> addCategory(@RequestBody ProductReqDTO productReqDTO) {
        try {
            return productManager.addProduct(productReqDTO);
        } catch (Exception e) {
            //Logger.getLogger(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResDTO>>getAllProduct(){
        return new ResponseEntity<>(productManager.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<ProductResDTO>getProductbyId(@PathVariable Long id){
        return new ResponseEntity<>(productManager.getProductById(id), HttpStatus.OK);
    }
}
