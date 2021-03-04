package com.webserver.finance.service;


import com.webserver.finance.models.IncomeCategory;

import java.util.List;

public interface IncomeCategoryService {
    //добавление продукта
    void create(IncomeCategory incomeCategory);

    //возврат всех продуктов
    List<IncomeCategory> readAll();

    //возврат продукта по его id
    IncomeCategory read(int id);

    //обновление продукта по его id
    boolean update(IncomeCategory incomeCategory, int id);

    //удаление продукта по id
    boolean delete(int id);
}
