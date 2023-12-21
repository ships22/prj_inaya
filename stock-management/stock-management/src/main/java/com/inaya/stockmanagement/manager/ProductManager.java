package com.inaya.stockmanagement.manager;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.Exception.StockManagementException;
import com.inaya.stockmanagement.dto.ProductReqDTO;
import com.inaya.stockmanagement.dto.ProductResDTO;
import com.inaya.stockmanagement.model.*;
import com.inaya.stockmanagement.service.category.CategoryService;
import com.inaya.stockmanagement.service.depot.DepotService;
import com.inaya.stockmanagement.service.product.ProductService;
import com.inaya.stockmanagement.service.stock.StockService;
import com.inaya.stockmanagement.service.supplier.SupplierService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProductManager {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    private final DepotService depotService;

    private final StockService stockService;

    public ProductManager(ProductService productService, CategoryService categoryService, SupplierService supplierService, DepotService depotService, StockService stockService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
        this.depotService = depotService;
        this.stockService = stockService;
    }

    @Transactional
    public ResponseEntity<ProductResDTO> addProduct(ProductReqDTO productReqDTO) throws StockManagementException {
        Optional<Category> category = categoryService.findById(productReqDTO.getCategoryId());
        Optional<Depot> depot = depotService.findById(productReqDTO.getCategoryId());
        Optional<Supplier> supplier = supplierService.findById(productReqDTO.getSupplierId());
        // Optional<Product> product = productService.findByName(productReqDTO.getName());

        /*product.ifPresent(value -> value.getStocks().forEach(data -> {
            if (Objects.equals(data.getDepot().getId(), productReqDTO.getDepotId())) {
                try {
                    throw new StockManagementException("Product already exists in "
                            + data.getDepot().getName()
                            + " depot, please update the stock rather.");
                } catch (StockManagementException e) {
                    throw new RuntimeException(e);
                }
            }
        }));*/

        if (category.isPresent() && depot.isPresent() && supplier.isPresent()) {

            //new stock -
            Stock stock = new Stock();
            stock.setQuantity(productReqDTO.getQuantity());
            stock.setDepot(depot.get());
            //stock.setProduct(addedProduct);
            Stock addedStock = stockService.add(stock);


            Product productToAdd = new Product();
            productToAdd.setName(productReqDTO.getName());
            productToAdd.setBuyPrice(productReqDTO.getBuyPrice());
            productToAdd.setCost(productReqDTO.getCost());
            productToAdd.setMargin(productReqDTO.getMargin());
            productToAdd.setDescription(productReqDTO.getDescription());
            productToAdd.setStocks(List.of(addedStock));
            productToAdd.setCategory(category.get());
            productToAdd.setSupplier(supplier.get());

            Product addedProduct = productService.add(productToAdd);


            Product product1 = productService.findById(addedProduct.getId()).get();
            return new ResponseEntity<>(toDto(product1), HttpStatus.CREATED);
        } else {
            throw new BaseException("Category, Depot or Supplier not found");
        }

    }

    public List<ProductResDTO> getAllProduct() {
        List<Product> productList = productService.getAll();
        //System.out.println("test here : + " + productList.toString());
        return productList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ProductResDTO getProductById(Long id) {
        Product product = productService.findById(id).get();
        return toDto(product);
    }

    private ProductResDTO toDto(Product product) {
        ProductResDTO productResDTO = new ProductResDTO();
        productResDTO.setId(product.getId());
        productResDTO.setName(product.getName());
        productResDTO.setDescription(product.getDescription());
        productResDTO.setBuyPrice(product.getBuyPrice());
        productResDTO.setCost(product.getCost());
        productResDTO.setMargin(product.getMargin());
        productResDTO.setCategory(product.getCategory());
        productResDTO.setSupplier(product.getSupplier());
        productResDTO.setStocks(product.getStocks());
        return productResDTO;
    }

}
