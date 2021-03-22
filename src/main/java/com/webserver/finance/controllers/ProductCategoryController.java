package com.webserver.finance.controllers;

import com.webserver.finance.models.ProductCategory;
import com.webserver.finance.models.Purchase;
import com.webserver.finance.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }
    @PostMapping(value = "/productcategories")
    public ResponseEntity<?> create(@RequestBody ProductCategory productCategory) {
        productCategoryService.create(productCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/productcategories")
    public ResponseEntity<List<ProductCategory>> read() {
        final List<ProductCategory> productcategories = productCategoryService.readAll();

        return productcategories != null &&  !productcategories.isEmpty()
                ? new ResponseEntity<>(productcategories, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/productcategories/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody ProductCategory productCategory) {
        final boolean updated = productCategoryService.update(productCategory, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/productcategories/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = productCategoryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/productcategories/{id}")
    public List<ProductCategory> readcategorybyuser(@PathVariable int id){
        return productCategoryService.readbyuser(id);
    }
}
