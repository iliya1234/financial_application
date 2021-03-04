package com.webserver.finance.service;

import com.webserver.finance.models.Income;

import java.util.List;

public interface IncomeService {
    //добавление продукта
    void create(Income income);

    //возврат всех продуктов
    List<Income> readAll();

    //возврат продукта по его id
    Income read(int id);

    //обновление продукта по его id
    boolean update(Income income, int id);

    //удаление продукта по id
    boolean delete(int id);
}
