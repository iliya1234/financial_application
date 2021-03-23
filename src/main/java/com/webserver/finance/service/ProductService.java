package com.webserver.finance.service;

import com.webserver.finance.models.Product;

import java.util.List;

public interface ProductService {

    //добавление продукта
    void create(Product product);

    //возврат всех продуктов
    List<Product> readAll();

    //возврат продукта по его id
    Product read(int id);

    //обновление продукта по его id
    boolean update(Product product, int id);

    //удаление продукта по id
    boolean delete(int id);

    //поиск продукта по id user из таблицы productcategory
    List<Product> readbyuser(int id);
}
