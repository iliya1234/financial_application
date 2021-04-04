package com.webserver.finance.service.Impl;


import com.webserver.finance.models.IncomeCategorization;
import com.webserver.finance.repository.IncomeCategorizationRepository;
import com.webserver.finance.service.Service.IncomeCategorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeCategorizationServiceImpl implements IncomeCategorizationService {
    @Autowired
    private IncomeCategorizationRepository incomeCategorizationRepository;

    @Override
    public void create(IncomeCategorization incomeCategorization) {
        incomeCategorizationRepository.save(incomeCategorization);
    }

    @Override
    public List<IncomeCategorization> readAll() {
        return incomeCategorizationRepository.findAll();
    }

    @Override
    public IncomeCategorization read(int id) {
        return incomeCategorizationRepository.getOne(id);
    }

    @Override
    public boolean update(IncomeCategorization incomeCategorization, int id) {
        if (incomeCategorizationRepository.existsById(id)) {
            incomeCategorization.setId_incomeproduct(id);
            incomeCategorizationRepository.save(incomeCategorization);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (incomeCategorizationRepository.existsById(id)) {
            incomeCategorizationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
