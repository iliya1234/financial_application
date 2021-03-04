package com.webserver.finance.service;


import com.webserver.finance.models.IncomeProduct;
import com.webserver.finance.repository.IncomeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeProductServiceImpl implements IncomeProductService{
    @Autowired
    private IncomeProductRepository incomeProductRepository;

    @Override
    public void create(IncomeProduct incomeProduct) {
        incomeProductRepository.save(incomeProduct);
    }

    @Override
    public List<IncomeProduct> readAll() {
        return incomeProductRepository.findAll();
    }

    @Override
    public IncomeProduct read(int id) {
        return incomeProductRepository.getOne(id);
    }

    @Override
    public boolean update(IncomeProduct incomeProduct, int id) {
        if (incomeProductRepository.existsById(id)) {
            incomeProduct.setId(id);
            incomeProductRepository.save(incomeProduct);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (incomeProductRepository.existsById(id)) {
            incomeProductRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
