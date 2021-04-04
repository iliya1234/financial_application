package com.webserver.finance.service.Service;

import com.webserver.finance.models.AuthorizationClient;


import java.util.List;

public interface AuthorizationClientService {
    void create(AuthorizationClient authorizationClient);

    //возврат всех продуктов
    List<AuthorizationClient> readAll();

    //возврат usera по его username и password
    List<AuthorizationClient> readUser(String username,String password);

    //обновление продукта по его id
    boolean update(AuthorizationClient authorizationClient, int id);

    //удаление продукта по id
    boolean delete(int id);

}
