package com.webserver.finance.service.Service;

import com.webserver.finance.models.Target;

import java.util.List;

public interface TargetService {

    void create(Target target);

    List<Target> readAll();

    Target read(int id);

    boolean update(Target target, int id);

    boolean delete(int id);

    //поиск целей конкретного пользователя
    List<Target> readbyusers(int id);
}
