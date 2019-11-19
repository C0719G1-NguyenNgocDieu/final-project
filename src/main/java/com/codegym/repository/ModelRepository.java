package com.codegym.repository;

import com.codegym.model.Model;
import com.codegym.model.Products;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModelRepository extends PagingAndSortingRepository<Model, Long> {
    Iterable<Products> findByNameModel(Model model);
}
