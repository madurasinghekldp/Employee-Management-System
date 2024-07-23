package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmployeeController {


    final EmployeeService service;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }

    @GetMapping("get-all")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @DeleteMapping("del/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteEmployee(@PathVariable Long id){
        service.deleteEmployeeById(id);
    }

    @PutMapping("update")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @GetMapping("get-by-id")
    public Employee findById(@RequestParam(name = "id") Long id){
        return service.findById(id);
    }

    @GetMapping("get-by-fname")
    public Employee findByFirstName(@RequestParam(name = "firstName") String firstName){
        return service.findByFirstName(firstName);
    }

    @GetMapping("count")
    public Long getCount(){
        return service.getCount();
    }
}
