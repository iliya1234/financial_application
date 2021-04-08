package com.webserver.finance.controllers;

import com.webserver.finance.models.Income;
import com.webserver.finance.models.Purchase;
import com.webserver.finance.service.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncomeController {
    private final IncomeService incomeService;
    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }
    @PostMapping(value = "/incomes")
    public ResponseEntity<?> create(@RequestBody Income income) {
        incomeService.create(income);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/incomes")
    public ResponseEntity<List<Income>> read() {
        final List<Income> incomes = incomeService.readAll();

        return incomes != null &&  !incomes.isEmpty()
                ? new ResponseEntity<>(incomes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/incomes/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Income income) {
        final boolean updated = incomeService.update(income, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/incomes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = incomeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/incomes/{id}")
    public List<Income> readPurchases(@PathVariable int id){
        return incomeService.readbyclient(id);
    }
    @GetMapping(value = "/incomes/info/{id}")
    public Income read(@PathVariable int id){
        return incomeService.readbyid(id);
    }
}
