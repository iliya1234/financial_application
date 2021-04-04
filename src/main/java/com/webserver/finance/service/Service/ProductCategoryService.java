package com.webserver.finance.service.Service;


import com.webserver.finance.models.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    //добавление продукта
    void create(ProductCategory productCategory);

    //возврат всех продуктов
    List<ProductCategory> readAll();

    //возврат продукта по его id
    ProductCategory read(int id);

    //обновление продукта по его id
    boolean update(ProductCategory productCategory, int id);

    //удаление продукта по id
    boolean delete(int id);

    List<ProductCategory> readbyuser(int id);
}
