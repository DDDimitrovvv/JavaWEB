package com.softuni.repository;

import com.softuni.model.entity.RoleEntity;
import com.softuni.model.entity.RoleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(RoleNameEnum roleNameEnum);
}
