package com.codegym.service.impl;

import com.codegym.model.Manufacturer;
import com.codegym.repository.ManufacturerRepository;
import com.codegym.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> findByAll() {
        return (List<Manufacturer>) manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Long id) {
        return manufacturerRepository.findById(id).get();
    }

    @Override
    public Manufacturer findByName(String name) {
        return manufacturerRepository.findByNameManufacturer(name);
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
