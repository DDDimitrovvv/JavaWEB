package com.softuni.service.impl;

import com.softuni.model.entity.RoleEntity;
import com.softuni.model.entity.RoleNameEnum;
import com.softuni.repository.RoleRepository;
import com.softuni.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {

//        iterating through the enumeration roles,
//        creating a role and save in the DB

            for ( RoleNameEnum role : RoleNameEnum.values() ){
                RoleEntity currentRole = new RoleEntity(role);
                roleRepository.save(currentRole);
            }

//        RoleEntity admin = new RoleEntity(RoleNameEnum.ADMIN);
//        RoleEntity user = new RoleEntity(RoleNameEnum.USER);
//
//        roleRepository.save(admin);
//        roleRepository.save(user);
        }
    }

    @Override
    public RoleEntity findRole(RoleNameEnum roleNameEnum) {
        return roleRepository
                .findByName(roleNameEnum)
                .orElse(null);
    }
}
