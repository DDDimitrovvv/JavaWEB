package com.softuni.model.service;

import com.softuni.model.entity.RoleEntity;

public class UserEntityServiceModel {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String git;
    private RoleEntity role;

    public UserEntityServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public UserEntityServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntityServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntityServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntityServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGit() {
        return git;
    }

    public UserEntityServiceModel setGit(String git) {
        this.git = git;
        return this;
    }

    public RoleEntity getRole() {
        return role;
    }

    public UserEntityServiceModel setRole(RoleEntity role) {
        this.role = role;
        return this;
    }
}
