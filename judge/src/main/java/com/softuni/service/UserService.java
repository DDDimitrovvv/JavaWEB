package com.softuni.service;

import com.softuni.model.service.UserEntityServiceModel;

public interface UserService {
    void registerUser(UserEntityServiceModel userEntityServiceModel);

    UserEntityServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserEntityServiceModel userEntityServiceModel);

    void logout();
}
