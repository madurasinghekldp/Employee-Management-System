package org.emp.service;

import org.emp.dto.Department;

import java.util.List;

public interface DepartmentService {
    Department addDep(Department department);

    List<Department> getAll();

    void deleteById(Long id);
}
