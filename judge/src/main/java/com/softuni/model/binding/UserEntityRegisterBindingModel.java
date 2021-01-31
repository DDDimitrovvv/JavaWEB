package com.softuni.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserEntityRegisterBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserEntityRegisterBindingModel() {
    }

    @Length(min = 2, message = "Username length must be minimum two characters!")
    @NotNull
    public String getUsername() {
        return username;
    }

    public UserEntityRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 3, message = "Password length must be minimum three characters!")
    @NotNull
    public String getPassword() {
        return password;
    }

    public UserEntityRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserEntityRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Email(message = "Enter valid email address!")
    @NotNull
    public String getEmail() {
        return email;
    }

    public UserEntityRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",
    message = "Please enter valid git address!")
    @NotNull
    public String getGit() {
        return git;
    }

    public UserEntityRegisterBindingModel setGit(String git) {
        this.git = git;
        return this;
    }
}
