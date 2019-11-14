package com.microservices.springwebapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.microservices.springwebapp.entity.RoleEntity;

public interface RoleDao extends CrudRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}
