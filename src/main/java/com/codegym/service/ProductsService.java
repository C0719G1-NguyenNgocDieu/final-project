package com.codegym.service;

import com.codegym.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductsService {
    Page<Products> findByAll(Pageable pageable);

    Page<Products> findByNameOrPrice(String name);

    Products findById(Long id);

    Products save(Products products);

    void delete(Long id);
}
