package com.codegym.service.impl;

import com.codegym.model.Manufacturer;
import com.codegym.model.Products;
import com.codegym.repository.ProductsRepository;
import com.codegym.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Products findById(Long id) {
        return productsRepository.findById(id).get();
    }

    @Override
    public Products findByNameProduct(String name) {
        return productsRepository.findByNameProduct(name);
    }

    @Override
    public Iterable<Products> findAllByPrice(Long price) {
        return productsRepository.findAllByPriceProduct(price);
    }

    @Override
    public Iterable<Products> findAllByManufacturer(Manufacturer manufacturer) {
        return productsRepository.findAllByManufacturer(manufacturer);
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
