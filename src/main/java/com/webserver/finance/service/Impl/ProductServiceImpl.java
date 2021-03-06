package com.webserver.finance.service.Impl;



import com.webserver.finance.models.Product;

import com.webserver.finance.repository.ProductRepository;
import com.webserver.finance.service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public Product read(int id) {
        return productRepository.getOne(id);
    }

    @Override
    public boolean update(Product product, int id) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> readbyuser(int id) {
        return productRepository.findByProductCategoryAuthorizationClientCategoryId(id);
    }

    @Override
    public List<Product> readbycategory(int id_category) {
        return productRepository.findByProductCategoryId(id_category);
    }

    @Override
    public List<Product> test() {
        return productRepository.getInfo();
    }

}
