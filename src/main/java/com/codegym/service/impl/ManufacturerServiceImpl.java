package com.codegym.service.impl;

import com.codegym.model.Manufacturer;
import com.codegym.repository.ManufacturerRepository;
import com.codegym.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findById(Long id) {
        return manufacturerRepository.findById(id).get();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer) l;
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
