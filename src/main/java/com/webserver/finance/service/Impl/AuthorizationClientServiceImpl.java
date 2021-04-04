package com.webserver.finance.service.Impl;

import com.webserver.finance.models.AuthorizationClient;
import com.webserver.finance.repository.AuthorizationClientRepository;
import com.webserver.finance.service.Service.AuthorizationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationClientServiceImpl implements AuthorizationClientService {
    @Autowired
    private AuthorizationClientRepository authorizationClientRepository;

    @Override
    public void create(AuthorizationClient authorizationClient) {
        authorizationClientRepository.save(authorizationClient);
    }

    @Override
    public List<AuthorizationClient> readAll() {
        return authorizationClientRepository.findAll();
    }

    @Override
    public List<AuthorizationClient> readUser(String username, String password) {
        return authorizationClientRepository.findByUsernameAndPassword(username,password);
    }


    @Override
    public boolean update(AuthorizationClient authorizationClient, int id) {
        if (authorizationClientRepository.existsById(id)) {
            authorizationClient.setId(id);
            authorizationClientRepository.save(authorizationClient);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (authorizationClientRepository.existsById(id)) {
            authorizationClientRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
