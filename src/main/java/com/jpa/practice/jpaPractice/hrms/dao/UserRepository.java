package com.jpa.practice.jpaPractice.hrms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.practice.jpaPractice.authentication.model.security.User;

@Repository
@Transactional
public class UserRepository {
	
	@Autowired
	private EntityManager em;
	
	public List<User> findAll(){
		TypedQuery<User> createQuery = em.createQuery("Select u from User u", User.class);
		List<User> resultList = createQuery.getResultList();
		return resultList;
	}
}
