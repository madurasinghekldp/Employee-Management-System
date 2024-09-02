package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Department;
import org.emp.entity.DepartmentEntity;
import org.emp.repository.DepartmentRepository;
import org.emp.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    private final ObjectMapper mapper;
    @Override
    public Department addDep(Department department) {
        DepartmentEntity saved = repository.save(mapper.convertValue(department, DepartmentEntity.class));
        return mapper.convertValue(saved, Department.class);
    }

    @Override
    public List<Department> getAll() {
        Iterable<DepartmentEntity> all = repository.findAll();
        List<Department> depList = new ArrayList<>();
        all.forEach(departmentEntity -> depList.add(mapper.convertValue(departmentEntity, Department.class)));
        return depList;
     }
}
