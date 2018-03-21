package com.test.service.impl;

import com.test.entity.Product;
import com.test.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements com.test.service.ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> finAll() {
        List<Product> list = productDao.findAll();
        return list;
    }
}
