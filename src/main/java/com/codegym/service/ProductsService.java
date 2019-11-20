package com.codegym.service;

import com.codegym.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductsService {
    Products findById(Long id);

    Page<Products> findByAll(Pageable pageable);

    Products save(Products products);

    void delete(Long id);
}
