package com.microservices.springwebapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.springwebapp.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
	
	@Query(value = "SELECT * FROM user", nativeQuery = true)
    List<UserEntity> selectAllUser();
	
	@Query(value = "SELECT * FROM user WHERE name = :name AND is_delete = 0", nativeQuery = true)
	UserEntity selectByName(@Param("name") String name);
}
