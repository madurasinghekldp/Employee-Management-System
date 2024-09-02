package org.emp.service.impl;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Role;
import org.emp.entity.RoleEntity;
import org.emp.repository.RoleRepository;
import org.emp.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final ModelMapper mapper;

    public Role save(Role role){
        RoleEntity saved = repository.save(mapper.map(role, RoleEntity.class));
        return mapper.map(saved, Role.class);
    }

    public List<Role> getAll(){
        Iterable<RoleEntity> all = repository.findAll();
        List<Role> roleList = new ArrayList<>();
        all.forEach(roleEntity -> {
            roleList.add(mapper.map(roleEntity, Role.class));
        });
        return roleList;
    }
}
