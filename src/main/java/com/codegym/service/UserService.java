package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByName(String name);

    User save(User user);

    void deleteById(Integer id);

    User findById(Integer id);
}
