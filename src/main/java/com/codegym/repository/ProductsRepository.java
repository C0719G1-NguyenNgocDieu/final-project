package com.codegym.repository;

import com.codegym.model.Manufacturer;
import com.codegym.model.Products;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductsRepository extends PagingAndSortingRepository<Products,Long> {
    Products findByNameProduct(String name);
    Iterable<Products> findAllByPriceProduct(Long price);
    Iterable<Products> findAllByManufacturer(Manufacturer manufacturer);
}
