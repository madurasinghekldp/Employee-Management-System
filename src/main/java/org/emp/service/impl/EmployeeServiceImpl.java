package org.emp.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeNativeRepository;
import org.emp.repository.EmployeeRepository;
import org.emp.service.EmployeeService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final ObjectMapper mapper;
    final EmployeeRepository repository;
    final EmployeeNativeRepository nativeRepository;

    @Override
    public void addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }

    @Override
    public List<Employee> getAll() {
        Iterable<EmployeeEntity> all = repository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        all.forEach(
                employeeEntity -> {
                    employeeList.add(mapper.convertValue(employeeEntity,Employee.class));
                }
        );
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if(repository.existsById(employee.getId())) {
            repository.save(mapper.convertValue(employee,EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(Long id) {
        return mapper.convertValue(repository.findById(id).get(),Employee.class);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return mapper.convertValue(repository.findByFirstName(firstName),Employee.class);
    }

    public Long getCount(){
        return nativeRepository.getCount();
    }
}
