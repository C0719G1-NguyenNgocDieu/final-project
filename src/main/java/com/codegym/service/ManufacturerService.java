package com.codegym.service;

import com.codegym.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer findById(Long id);

    Manufacturer save(Manufacturer manufacturer);

    void delete(Long id);
}
