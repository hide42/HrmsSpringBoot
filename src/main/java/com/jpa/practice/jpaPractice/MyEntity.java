package com.jpa.practice.jpaPractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
public class MyEntity {
/*
	@Id
	@SequenceGenerator(name="sampleSequence", sequenceName="entity_seq", allocationSize=50, initialValue=1)
	@TableGenerator(name="tableSequence", pkColumnName="pkCol", pkColumnValue="1", table="Table_Seq")
	@GeneratedValue(generator="tableSequence")
	private int id;
	
	private MyEnum myEnum;
	
	@Temporal(TemporalType.DATE)
	private Date firstDate;
	@Temporal(TemporalType.TIME)
	private Date firstTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date secondTime;
	
	public MyEntity() {
		super();
	}
	public static MyEntity create(MyEnum myEnum, LocalDate localDate, LocalTime localTime, LocalDateTime localTime2) {
		MyEntity myE = new MyEntity();
		myE.setMyEnum(myEnum);
		
		Calendar cDate = Calendar.getInstance();
		cDate.clear();
		cDate.set(localDate.getYear(), localDate.getMonthValue()-1, localDate.getDayOfMonth());
		myE.setFirstDate(cDate.getTime());
		
		cDate.clear();
		cDate.set(0, 0, 0, localTime.getHour(), localTime.getMinute(), localTime.getSecond());
		myE.setFirstTime(cDate.getTime());
		
		cDate.clear();
		cDate.set(localTime2.getYear(), localTime2.getMonthValue()-1, localTime2.getDayOfMonth(), localTime2.getHour(), localTime2.getMinute(), localTime2.getSecond());
		myE.setSecondTime(cDate.getTime());

		return myE;

	}
	
	public Date getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	public Date getSecondTime() {
		return secondTime;
	}
	public void setSecondTime(Date secondTime) {
		this.secondTime = secondTime;
	}
	public MyEnum getMyEnum() {
		return myEnum;
	}
	public void setMyEnum(MyEnum myEnum) {
		this.myEnum = myEnum;
	}
	
*/	
	
}
