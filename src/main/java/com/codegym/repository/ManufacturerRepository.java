package com.codegym.repository;

import com.codegym.model.Manufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ManufacturerRepository extends PagingAndSortingRepository<Manufacturer,Long> {
}
