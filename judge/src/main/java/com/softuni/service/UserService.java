package com.softuni.service;

import com.softuni.model.entity.RoleNameEnum;
import com.softuni.model.entity.UserEntity;
import com.softuni.model.service.UserEntityServiceModel;

import java.util.List;

public interface UserService {
    void registerUser(UserEntityServiceModel userEntityServiceModel);

    UserEntityServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserEntityServiceModel userEntityServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    UserEntity findById(Long id);
}
