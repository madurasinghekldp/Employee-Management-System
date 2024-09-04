package org.emp.controller;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Role;
import org.emp.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public Role addRole(@RequestBody Role role){
        return roleService.save(role);
    }

    @GetMapping("/all")
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@RequestParam(name="id") Long id){
        roleService.deleteById(id);
    }
}
