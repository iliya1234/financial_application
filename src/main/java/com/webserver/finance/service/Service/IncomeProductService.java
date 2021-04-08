package com.webserver.finance.service.Service;

import com.webserver.finance.models.IncomeProduct;
import com.webserver.finance.models.Product;

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

    //поиск продукта по id user из таблицы productcategory
    List<IncomeProduct> readincomeproductbyuser(int id);

    //поиск продуктов по категории и по id_user
    List<IncomeProduct> readbycategory(int id_categor);
}
