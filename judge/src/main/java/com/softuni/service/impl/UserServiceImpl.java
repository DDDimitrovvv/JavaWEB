package com.softuni.service.impl;

import com.softuni.model.entity.RoleNameEnum;
import com.softuni.model.entity.UserEntity;
import com.softuni.model.service.UserEntityServiceModel;
import com.softuni.repository.UserRepository;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(UserEntityServiceModel userEntityServiceModel) {
        UserEntity user = modelMapper.map(userEntityServiceModel, UserEntity.class);
        user.setRole(roleService.findRole(RoleNameEnum.USER));
        userRepository.save(user);

    }

    @Override
    public UserEntityServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserEntityServiceModel.class))
                .orElse(null);
    }
}
