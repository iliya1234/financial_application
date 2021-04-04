package com.webserver.finance.service.Service;


import com.webserver.finance.models.ProductCategorization;

import java.util.List;

public interface ProductCategorizatoinService {
    //добавление продукта
    void create(ProductCategorization productCategorization);

    //возврат всех продуктов
    List<ProductCategorization> readAll();

    //возврат продукта по его id
    ProductCategorization read(int id);

    //обновление продукта по его id
    boolean update(ProductCategorization productCategorization, int id);

    //удаление продукта по id
    boolean delete(int id);
}
