package com.codegym.repository;

import com.codegym.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductsRepository extends PagingAndSortingRepository<Products,Long> {
    Page<Products> findByNameProductOrPriceProduct(String nameOrPrice);
}
