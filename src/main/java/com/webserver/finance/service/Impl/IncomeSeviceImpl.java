package com.webserver.finance.service.Impl;



import com.webserver.finance.models.Income;
import com.webserver.finance.repository.IncomeRepository;
import com.webserver.finance.service.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeSeviceImpl implements IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public void create(Income income) {
        incomeRepository.save(income);
    }

    @Override
    public List<Income> readAll() {
        return incomeRepository.findAll();
    }

    @Override
    public Income read(int id) {
        return incomeRepository.getOne(id);
    }

    @Override
    public boolean update(Income income, int id) {
        if (incomeRepository.existsById(id)) {
            income.setId(id);
            incomeRepository.save(income);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (incomeRepository.existsById(id)) {
            incomeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
