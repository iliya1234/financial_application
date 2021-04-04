package com.webserver.finance.service.Service;

import com.webserver.finance.models.IncomeProduct;

import java.util.List;

public interface IncomeProductService {
    //добавление продукта
    void create(IncomeProduct incomeProduct);

    //возврат всех продуктов
    List<IncomeProduct> readAll();

    //возврат продукта по его id
    IncomeProduct read(int id);

    //обновление продукта по его id
    boolean update(IncomeProduct incomeProduct, int id);

    //удаление продукта по id
    boolean delete(int id);
}
