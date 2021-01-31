package com.softuni.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String username;
    private String password;
    private String email;
    private String git;
    private RoleEntity role;

    public UserEntity() {
    }

    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "git")
    public String getGit() {
        return git;
    }

    public UserEntity setGit(String git) {
        this.git = git;
        return this;
    }

    @ManyToOne
    public RoleEntity getRole() {
        return role;
    }

    public UserEntity setRole(RoleEntity role) {
        this.role = role;
        return this;
    }
}
