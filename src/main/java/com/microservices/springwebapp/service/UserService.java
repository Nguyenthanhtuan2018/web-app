package com.microservices.springwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservices.springwebapp.dao.UserDao;
import com.microservices.springwebapp.dao.impl.UserCustomDaoImpl;
import com.microservices.springwebapp.entity.UserEntity;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserCustomDaoImpl userCustomDaoImpl;
	
	public List<UserEntity> listUser1() {

		return userDao.selectAllUser();
	}
	
	public List<UserEntity> listUser2() {

		return userCustomDaoImpl.selectAllUser();
	}
	
	public Object selectByName1(@PathVariable String name) {

		return userCustomDaoImpl.getUserByName(name);
	}
	
	public UserEntity selectByName2 (@PathVariable String name) {

		return userDao.selectByName(name);
	}
	
	public Object findById (Long id) {

		return userDao.findById(id);
	}
}
