package com.webserver.finance.service;

import com.webserver.finance.models.AuthorizationClient;


import java.util.List;

public interface AuthorizationClientService {
    void create(AuthorizationClient authorizationClient);

    //возврат всех продуктов
    List<AuthorizationClient> readAll();

    //возврат продукта по его id
    AuthorizationClient read(int id);

    //обновление продукта по его id
    boolean update(AuthorizationClient authorizationClient, int id);

    //удаление продукта по id
    boolean delete(int id);
}
