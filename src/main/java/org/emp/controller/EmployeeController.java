package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {


    final EmployeeService service;

    @PostMapping("add")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("get")
    public List<Employee> getAll(){
        return service.getAll();
    }
}
