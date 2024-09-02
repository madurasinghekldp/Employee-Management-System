package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Department;
import org.emp.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public Department addDep(@RequestBody Department department){
        return departmentService.addDep(department);
    }

    @GetMapping("/all")
    public List<Department> getAll(){
        return departmentService.getAll();
    }
}
