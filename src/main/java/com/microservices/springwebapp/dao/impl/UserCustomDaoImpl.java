package com.microservices.springwebapp.dao.impl;

import static com.microservices.springwebapp.query.UserQuery.createQueryToGetUserEntityByName;
import static com.microservices.springwebapp.query.UserQuery.createQueryToGetAllUser;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.microservices.springwebapp.dao.UserCustomDao;
import com.microservices.springwebapp.entity.UserEntity;

@Service
public class UserCustomDaoImpl implements UserCustomDao{
	
	@PersistenceContext
    private EntityManager entityManager ;

	@Override
	public Object getUserByName(String name) {
		
		return  (Object) entityManager.createNativeQuery(
				createQueryToGetUserEntityByName.apply(name)).getSingleResult();
	}
	
	@Override
	public List<UserEntity> selectAllUser() {
		
		return  (List<UserEntity>) entityManager.createNativeQuery(
				createQueryToGetAllUser(), UserEntity.class).getResultList();
	}

}
