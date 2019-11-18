package com.codegym.service.impl;

import com.codegym.model.Model;
import com.codegym.repository.ModelRepository;
import com.codegym.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelRepository modelRepository;

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id).get();
    }

    @Override
    public Model findByName(String name) {
        return modelRepository.findByNameModel(name);
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        modelRepository.deleteById(id);
    }
}
