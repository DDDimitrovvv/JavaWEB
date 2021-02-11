package com.softuni.service.impl;

import com.softuni.model.entity.RoleNameEnum;
import com.softuni.model.entity.UserEntity;
import com.softuni.model.service.UserEntityServiceModel;
import com.softuni.repository.UserRepository;
import com.softuni.security.CurrentUser;
import com.softuni.service.RoleService;
import com.softuni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
        this.currentUser = currentUser;
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

    @Override
    public void login(UserEntityServiceModel userEntityServiceModel) {
        currentUser
                .setId(userEntityServiceModel.getId())
                .setUsername(userEntityServiceModel.getUsername())
                .setRole(userEntityServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser
                .setId(null)
                .setUsername(null)
                .setRole(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {

        //We can use UserEntity instead of Optional

        Optional<UserEntity> user = userRepository
                .findByUsername(username);

        if (user.isPresent()) {
            if (user.get().getRole().getName() != roleNameEnum) {
                user.get().setRole(roleService.findRole(roleNameEnum));
                userRepository.save(user.get());
            }
        }

    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
