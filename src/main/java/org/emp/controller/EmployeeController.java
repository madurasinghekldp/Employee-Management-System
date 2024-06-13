package org.emp.controller;

import org.emp.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();

    @PostMapping("add")
    public void addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
    }

    @GetMapping("get")
    public List<Employee> getAll(){
        return employeeList;
    }
}
