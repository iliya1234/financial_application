package com.webserver.finance.controllers;


import com.webserver.finance.models.IncomeProduct;
import com.webserver.finance.models.Product;
import com.webserver.finance.service.Service.IncomeProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncomeProductController {
    private final IncomeProductService incomeProductService;

    IncomeProductController(IncomeProductService incomeProductService)
    {
        this.incomeProductService = incomeProductService;
    }

    @PostMapping(value = "/incomeproducts")
    public ResponseEntity<?> create(@RequestBody IncomeProduct incomeProduct) {
        incomeProductService.create(incomeProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/incomeproducts")
    public ResponseEntity<List<IncomeProduct>> read() {
        final List<IncomeProduct> incomeproducts = incomeProductService.readAll();

        return incomeproducts != null &&  !incomeproducts.isEmpty()
                ? new ResponseEntity<>(incomeproducts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/incomeproducts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody IncomeProduct incomeProduct) {
        final boolean updated = incomeProductService.update(incomeProduct, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/incomeproducts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = incomeProductService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/incomeproducts/{id}")
    public List<IncomeProduct> readByUserID(@PathVariable int id){
        return incomeProductService.readincomeproductbyuser(id);
    }

    @GetMapping(value = "/incomeproducts/category/{id_category}")
    public List<IncomeProduct> readByCategoryID(@PathVariable int id_category){
        return incomeProductService.readbycategory(id_category);
    }
}
