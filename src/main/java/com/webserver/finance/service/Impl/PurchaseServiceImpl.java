package com.webserver.finance.service.Impl;

import com.webserver.finance.models.Purchase;
import com.webserver.finance.repository.PurchaseRepository;
import com.webserver.finance.service.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public void create(Purchase purchase)
    {
        purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> readAll(){
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase read(int id) {
        return purchaseRepository.getOne(id);
    }

    @Override
    public boolean update(Purchase purchase, int id) {
        if (purchaseRepository.existsById(id)) {
            purchase.setId(id);
            purchaseRepository.save(purchase);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (purchaseRepository.existsById(id)) {
            purchaseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Purchase> readbyclient(int id) {
        return purchaseRepository.findByProductProductCategoryAuthorizationClientCategoryIdOrderByDateDesc(id);
    }

    @Override
    public Purchase readbyid(int id) {
        return purchaseRepository.findById(id);
    }


}
