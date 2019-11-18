package com.codegym.service;

import com.codegym.model.Model;

public interface ModelService {
    Model findById(Long id);

    Model findByName(String name);

    Model save(Model model);

    void delete(Long id);
}
