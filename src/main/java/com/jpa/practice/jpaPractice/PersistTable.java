package com.jpa.practice.jpaPractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
//@Transactional
public class PersistTable {
/*
	@Autowired
	private EntityManager em;
	
	public void insertRecord() {
		MyEntity me = MyEntity.create(MyEnum.constC, LocalDate.of(2018, 8, 01),LocalTime.of(10, 00, 00), LocalDateTime.of(2018, 02, 01, 10, 01));
		em.persist(me);
		
		Customer cust = new Customer();
		cust.setName("Customer name");
		
		Orders ord = new Orders();
		ord.setItemname("Order Item");
		cust.setOrders(ord);
//		em.persist(ord);
		em.persist(cust);
		
	}*/
}
