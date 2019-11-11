package com.codegym.service;

import com.codegym.model.Role;

public interface RoleService {
    Role findByName(String name);
}
