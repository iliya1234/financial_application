package com.webserver.finance.service;


import com.webserver.finance.models.IncomeCategorization;

import java.util.List;

public interface IncomeCategorizationService {
    //добавление продукта
    void create(IncomeCategorization incomeCategorization);

    //возврат всех продуктов
    List<IncomeCategorization> readAll();

    //возврат продукта по его id
    IncomeCategorization read(int id);

    //обновление продукта по его id
    boolean update(IncomeCategorization incomeCategorization, int id);

    //удаление продукта по id
    boolean delete(int id);
}
