package com.webserver.finance.service;


import com.webserver.finance.models.ProductCategory;
import com.webserver.finance.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public void create(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> readAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory read(int id) {
        return productCategoryRepository.getOne(id);
    }

    @Override
    public boolean update(ProductCategory productCategory, int id) {
        if (productCategoryRepository.existsById(id)) {
            productCategory.setId(id);
            productCategoryRepository.save(productCategory);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (productCategoryRepository.existsById(id)) {
            productCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<ProductCategory> readbyuser(int id) {
        return productCategoryRepository.findByAuthorizationClientCategoryId(id);
    }
}
