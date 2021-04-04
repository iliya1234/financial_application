package com.webserver.finance.service.Impl;


import com.webserver.finance.models.IncomeCategory;
import com.webserver.finance.repository.IncomeCategoryRepository;
import com.webserver.finance.service.Service.IncomeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeCategoryServiceImpl implements IncomeCategoryService {
    @Autowired
    private IncomeCategoryRepository incomeCategoryRepository;

    @Override
    public void create(IncomeCategory incomeCategory) {
        incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    public List<IncomeCategory>  readAll() {
        return incomeCategoryRepository.findAll();
    }

    @Override
    public IncomeCategory read(int id) {
        return incomeCategoryRepository.getOne(id);
    }

    @Override
    public boolean update(IncomeCategory incomeCategory, int id) {
        if (incomeCategoryRepository.existsById(id)) {
            incomeCategory.setId(id);
            incomeCategoryRepository.save(incomeCategory);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (incomeCategoryRepository.existsById(id)) {
            incomeCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
