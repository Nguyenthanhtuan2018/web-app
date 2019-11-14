package com.microservices.springwebapp.dao;

import java.util.List;

import com.microservices.springwebapp.entity.UserEntity;

public interface UserCustomDao {
	
	Object getUserByName(String name);
	
	List<UserEntity> selectAllUser();
}
