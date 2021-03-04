package com.webserver.finance.controllers;

import com.webserver.finance.models.Purchase;
import com.webserver.finance.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(value = "/purchases")
    public ResponseEntity<?> create(@RequestBody Purchase purchase) {
        purchaseService.create(purchase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/purchases")
    public ResponseEntity<List<Purchase>> read() {
        final List<Purchase> purchases = purchaseService.readAll();

        return purchases != null &&  !purchases.isEmpty()
                ? new ResponseEntity<>(purchases, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/purchases/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Purchase purchase) {
        final boolean updated = purchaseService.update(purchase, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/purchases/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = purchaseService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
