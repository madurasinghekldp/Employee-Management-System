package org.emp.repository.impl;

import lombok.RequiredArgsConstructor;
import org.emp.repository.EmployeeNativeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeNativeRepositoryImpl implements EmployeeNativeRepository {

    final JdbcTemplate jdbcTemplate;
    @Override
    public Long getCount() {
        return jdbcTemplate.queryForObject("select count(*) from employee",Long.class);
    }
}
