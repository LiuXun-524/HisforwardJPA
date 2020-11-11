package com.example.demojpa.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_invoice")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Invoice {
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "id", length = 32, nullable = false)
	private String id;
	@Column(name = "invoiceNum", nullable = false, length = 64)
	private String invoiceNum;
	private double money;
	
	private int state;
	@Column(name = "creationTime", nullable = false, length = 64)
	private String creationTime;
	
	private int userID;
	private String registID;
	private String feeType;
	
	@Column(name = "back",length = 64)
	private String back;
	
	private int dailyState;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	

	

	public String getRegistID() {
		return registID;
	}

	public void setRegistID(String registID) {
		this.registID = registID;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public int getDailyState() {
		return dailyState;
	}

	public void setDailyState(int dailyState) {
		this.dailyState = dailyState;
	}


}
