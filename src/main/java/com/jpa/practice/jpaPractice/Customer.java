package com.jpa.practice.jpaPractice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

//@Entity
public class Customer {

/*	@TableGenerator(name="tableSequence", pkColumnName="pkCol", pkColumnValue="1", table="Table_Seq")
	@Id @GeneratedValue(generator="tableSequence")
	private int id;
	
	private String name;

	@OneToOne(optional=false, cascade=CascadeType.PERSIST)
	@JoinTable(name="Customer_Orders",
			joinColumns={@JoinColumn(name="Cust_Pk", referencedColumnName="id", table="Customer")},
			inverseJoinColumns={ @JoinColumn(name="Ord_Pk", referencedColumnName="id", table="Orders") }
			)
	private Orders orders;
	
	
	
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Customer() {
		super();
	}
*/	
}
