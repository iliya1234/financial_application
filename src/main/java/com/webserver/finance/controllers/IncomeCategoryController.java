package com.webserver.finance.controllers;


import com.webserver.finance.models.IncomeCategory;
import com.webserver.finance.service.IncomeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncomeCategoryController {
    private final IncomeCategoryService incomeCategoryService;
    @Autowired
    public IncomeCategoryController(IncomeCategoryService incomeCategoryService) {
        this.incomeCategoryService = incomeCategoryService;
    }
    @PostMapping(value = "/incomecategories")
    public ResponseEntity<?> create(@RequestBody IncomeCategory incomeCategory) {
        incomeCategoryService.create(incomeCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/incomecategories")
    public ResponseEntity<List<IncomeCategory>> read() {
        final List<IncomeCategory> incomescategories = incomeCategoryService.readAll();

        return incomescategories != null &&  !incomescategories.isEmpty()
                ? new ResponseEntity<>(incomescategories, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/incomecategories/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody IncomeCategory incomeCategory) {
        final boolean updated = incomeCategoryService.update(incomeCategory, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/incomecategories/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = incomeCategoryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
