package com.microservices.springwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.springwebapp.entity.UserEntity;
import com.microservices.springwebapp.service.UserService;

@RestController
public class HeartBeat {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = { "/getList"})
	public List<UserEntity> listUser1() {

		return userService.listUser1();
	}
	
	@RequestMapping(value = { "/getList2"})
	public List<UserEntity> listUser2() {

		return userService.listUser2();
	}
	
	@RequestMapping(value = { "/findByName/{name}"})
	public Object selectByName1(@PathVariable String name) {

		return userService.selectByName1(name);
	}
	
	@RequestMapping(value = { "/findByName2/{name}"})
	public UserEntity selectByName2 (@PathVariable String name) {

		return userService.selectByName2(name);
	}
}
