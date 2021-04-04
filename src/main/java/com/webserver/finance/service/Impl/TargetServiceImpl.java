package com.webserver.finance.service.Impl;

import com.webserver.finance.models.IncomeProduct;
import com.webserver.finance.models.Target;
import com.webserver.finance.repository.IncomeProductRepository;
import com.webserver.finance.repository.TargetRepository;
import com.webserver.finance.service.Service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetRepository targetRepository;

    @Override
    public void create(Target target) {
        targetRepository.save(target);
    }

    @Override
    public List<Target> readAll() {
        return targetRepository.findAll();
    }

    @Override
    public Target read(int id) {
        return targetRepository.getOne(id);
    }

    @Override
    public boolean update(Target target, int id) {
        if (targetRepository.existsById(id)) {
            target.setId(id);
            targetRepository.save(target);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (targetRepository.existsById(id)) {
            targetRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Target> readbyusers(int id) {
        return targetRepository.findByUsersId(id);
    }
}
