package com.webserver.finance.service.Service;

import com.webserver.finance.models.Income;
import com.webserver.finance.models.Purchase;

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

    List<Income> readbyclient(int id);

    Income readbyid(int id);

    List<Object[]>readtodaytotal(int id);

    List<Object[]>readweektotal(int id);

    List<Object[]>readmonthtotal(int id);

    List<Object[]>readyeartotal(int id);
}
