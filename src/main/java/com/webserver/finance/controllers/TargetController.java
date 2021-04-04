package com.webserver.finance.controllers;

import com.webserver.finance.models.Income;
import com.webserver.finance.models.ProductCategory;
import com.webserver.finance.models.Target;
import com.webserver.finance.service.Service.IncomeService;
import com.webserver.finance.service.Service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TargetController {
    private final TargetService targetService;
    @Autowired
    public TargetController(TargetService targetService) {
        this.targetService = targetService;
    }
    @PostMapping(value = "/targets")
    public ResponseEntity<?> create(@RequestBody Target target) {
        targetService.create(target);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/targets")
    public ResponseEntity<List<Target>> read() {
        final List<Target> targets = targetService.readAll();

        return targets != null &&  !targets.isEmpty()
                ? new ResponseEntity<>(targets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/targets/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Target target) {
        final boolean updated = targetService.update(target, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/targets/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = targetService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/targets/{id}")
    public List<Target> readbyuser(@PathVariable int id){
        return targetService.readbyusers(id);
    }
}
