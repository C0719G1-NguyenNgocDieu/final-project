package com.codegym.repository;

import com.codegym.model.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model,Long> {
    Model findByNameModel(String name);
}
