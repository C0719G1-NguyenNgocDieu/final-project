package com.codegym.service;

import com.codegym.model.Manufacturer;
import com.codegym.model.Products;

public interface ProductsService {
    Products findById(Long id);

    Products findByNameProduct(String name);

    Iterable<Products> findAllByPrice(Long price);

    Iterable<Products> findAllByManufacturer(Manufacturer manufacturer);

    Products save(Products products);

    void delete(Long id);
}
