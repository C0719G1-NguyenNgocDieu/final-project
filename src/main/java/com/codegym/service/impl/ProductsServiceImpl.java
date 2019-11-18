package com.codegym.service.impl;

import com.codegym.model.Products;
import com.codegym.repository.ProductsRepository;
import com.codegym.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Page<Products> findByAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public Page<Products> findByNameOrPrice(String name) {
        return productsRepository.findByNameProductOrPriceProduct(name);
    }

    @Override
    public Products findById(Long id) {
        return productsRepository.findById(id).get();
    }

    @Override
    public Products save(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}
