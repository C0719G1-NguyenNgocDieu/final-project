package com.codegym.service;

import com.codegym.model.Model;
import com.codegym.model.Products;

public interface ModelService {
    Model findById(Long id);

    Products findByNameModel(Model model);

    Model save(Model model);

    void delete(Long id);
}
