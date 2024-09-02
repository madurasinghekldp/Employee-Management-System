package org.emp.service;

import org.emp.dto.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);
    List<Role> getAll();
}
