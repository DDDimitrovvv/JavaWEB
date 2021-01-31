package com.softuni.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserEntityLoginBindingModel {

    private String username;
    private String password;

    public UserEntityLoginBindingModel() {
    }

    @Length(min = 2, message = "Username length must be minimum two characters!")
    @NotNull
    public String getUsername() {
        return username;
    }

    public UserEntityLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 3, message = "Password length must be minimum three characters!")
    @NotNull
    public String getPassword() {
        return password;
    }

    public UserEntityLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }


}
