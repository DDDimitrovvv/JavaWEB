package com.softuni.service;

import com.softuni.model.entity.RoleEntity;
import com.softuni.model.entity.RoleNameEnum;

public interface RoleService {
    void initRoles();

    RoleEntity findRole(RoleNameEnum roleNameEnum);
}
