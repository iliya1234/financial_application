package com.webserver.finance.service.Service;

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

    //поиск по определенному клиенту, вывод продукта по имени
    List<Purchase> readbyclient(int id);

    Purchase readbyid(int id);

    List<Object[]>readtodaytotal(int id);

    List<Object[]>readweektotal(int id);

    List<Object[]>readmonthtotal(int id);

    List<Object[]>readyeartotal(int id);

}
