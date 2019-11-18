package com.codegym.service;

import com.codegym.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findByAll();

    Manufacturer findById(Long id);

    Manufacturer findByName(String name);

    Manufacturer save(Manufacturer manufacturer);

    void delete(Long id);
}
