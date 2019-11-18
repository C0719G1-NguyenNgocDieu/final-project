package com.codegym.repository;

import com.codegym.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer,Long> {
    Manufacturer findByNameManufacturer(String name);
}
