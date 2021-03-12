package com.webserver.finance.controllers;

import com.webserver.finance.models.AuthorizationClient;
import com.webserver.finance.service.AuthorizationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AuthorizationClientController {
    private final AuthorizationClientService authorizationClientService;
    @Autowired
    public AuthorizationClientController(AuthorizationClientService authorizationClientService) {
        this.authorizationClientService = authorizationClientService;
    }
    @PostMapping(value = "/authorizationclients")
    public ResponseEntity<?> create(@RequestBody AuthorizationClient authorizationClient) {
        authorizationClientService.create(authorizationClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/authorizationclients")
    public ResponseEntity<List<AuthorizationClient>> read() {
        final List<AuthorizationClient> authorizationclients = authorizationClientService.readAll();

        return authorizationclients != null &&  !authorizationclients.isEmpty()
                ? new ResponseEntity<>(authorizationclients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/authorizationclients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody AuthorizationClient authorizationClient) {
        final boolean updated = authorizationClientService.update(authorizationClient, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/authorizationclients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = authorizationClientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/authorizationclients/{name}&{password}")
    public List<AuthorizationClient> readUser(@PathVariable String name,@PathVariable String password){
        return authorizationClientService.readUser(name,password);
    }
}
