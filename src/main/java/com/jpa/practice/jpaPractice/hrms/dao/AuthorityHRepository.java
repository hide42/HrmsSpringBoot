package com.jpa.practice.jpaPractice.hrms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jpa.practice.jpaPractice.hrms.AuthorityH;

@Repository
@Transactional
public class AuthorityHRepository {

	@Autowired
	private EntityManager em;
	
	@Transactional
	public List<AuthorityH> getAllUsers() {
		TypedQuery<AuthorityH> createQuery = em.createQuery("Select a from AuthorityH a", AuthorityH.class);
		List<AuthorityH> resultList = createQuery.getResultList();
		return resultList;
	}
	
	public AuthorityH getUser(int id){
		AuthorityH find = em.find(AuthorityH.class, id);
		return find;
	}
}
