package com.webserver.finance.service;

import com.webserver.finance.models.Purchase;

import java.util.List;

public interface PurchaseService {
    //добавление продукта
    void create(Purchase purchase);

    //возврат всех продуктов
    List<Purchase> readAll();

    //возврат продукта по его id
    Purchase read(int id);

    //обновление продукта по его id
    boolean update(Purchase purchase, int id);

    //удаление продукта по id
    boolean delete(int id);
}
