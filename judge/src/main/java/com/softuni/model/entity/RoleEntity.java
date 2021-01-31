package com.softuni.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{


    private RoleNameEnum name;

    public RoleEntity() {
    }

    public RoleEntity(RoleNameEnum name) {
        this.name = name;
    }

    @Enumerated(value = EnumType.STRING)
    public RoleNameEnum getName() {
        return name;
    }

    public RoleEntity setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}
