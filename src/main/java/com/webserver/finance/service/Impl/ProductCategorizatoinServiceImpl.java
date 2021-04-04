package com.webserver.finance.service.Impl;

import com.webserver.finance.models.ProductCategorization;
import com.webserver.finance.repository.ProductCategorizatoinRepository;
import com.webserver.finance.service.Service.ProductCategorizatoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategorizatoinServiceImpl implements ProductCategorizatoinService {
    @Autowired
    private ProductCategorizatoinRepository productCategorizatoinRepository;

    @Override
    public void create(ProductCategorization productCategorization) {
        productCategorizatoinRepository.save(productCategorization);
    }

    @Override
    public List<ProductCategorization>  readAll() {
        return productCategorizatoinRepository.findAll();
    }

    @Override
    public ProductCategorization read(int id) {
        return productCategorizatoinRepository.getOne(id);
    }

    @Override
    public boolean update(ProductCategorization productCategorization, int id) {
        if (productCategorizatoinRepository.existsById(id)) {
            productCategorization.setId_product(id);
            productCategorizatoinRepository.save(productCategorization);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (productCategorizatoinRepository.existsById(id)) {
            productCategorizatoinRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
