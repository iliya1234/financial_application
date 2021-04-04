package com.webserver.finance.controllers;


import com.webserver.finance.models.IncomeCategorization;
import com.webserver.finance.service.Service.IncomeCategorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncomeCategorizationController {
    private final IncomeCategorizationService incomeCategorizationService;
    @Autowired
    public IncomeCategorizationController(IncomeCategorizationService incomeCategorizationService) {
        this.incomeCategorizationService = incomeCategorizationService;
    }
    @PostMapping(value = "/incomecategorizations")
    public ResponseEntity<?> create(@RequestBody IncomeCategorization incomeCategorization) {
        incomeCategorizationService.create(incomeCategorization);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/incomecategorizations")
    public ResponseEntity<List<IncomeCategorization>> read() {
        final List<IncomeCategorization> incomecategorizations = incomeCategorizationService.readAll();

        return incomecategorizations != null &&  !incomecategorizations.isEmpty()
                ? new ResponseEntity<>(incomecategorizations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/incomecategorizations/{id_incomeproduct}")
    public ResponseEntity<?> update(@PathVariable(name = "id_incomeproduct") int id_incomeproduct, @RequestBody IncomeCategorization incomeCategorization) {
        final boolean updated = incomeCategorizationService.update(incomeCategorization, id_incomeproduct);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/incomecategorizations/{id_incomeproduct}")
    public ResponseEntity<?> delete(@PathVariable(name = "id_incomeproduct") int id_incomeproduct) {
        final boolean deleted = incomeCategorizationService.delete(id_incomeproduct);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
