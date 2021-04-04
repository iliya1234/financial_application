package com.webserver.finance.controllers;


import com.webserver.finance.models.ProductCategorization;
import com.webserver.finance.service.Service.ProductCategorizatoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategorizationController {
    private final ProductCategorizatoinService productCategorizatoinService;
    @Autowired
    public ProductCategorizationController(ProductCategorizatoinService productCategorizatoinService) {
        this.productCategorizatoinService = productCategorizatoinService;
    }


    @PostMapping(value = "/productcategorizatoins")
    public ResponseEntity<?> create(@RequestBody ProductCategorization productCategorization) {
        productCategorizatoinService.create(productCategorization);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/productcategorizatoins")
    public ResponseEntity<List<ProductCategorization>> read() {
        final List<ProductCategorization> productCategorizations = productCategorizatoinService.readAll();

        return productCategorizations != null &&  !productCategorizations.isEmpty()
                ? new ResponseEntity<>(productCategorizations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/productcategorizatoins/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id_product") int id_product, @RequestBody ProductCategorization productCategorization) {
        final boolean updated = productCategorizatoinService.update(productCategorization, id_product);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/productcategorizatoins/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id_product") int id_product) {
        final boolean deleted = productCategorizatoinService.delete(id_product);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
