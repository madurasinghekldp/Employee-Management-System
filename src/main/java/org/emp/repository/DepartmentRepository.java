package org.emp.repository;

import org.emp.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Long> {
}
