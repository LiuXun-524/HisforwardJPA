package com.example.demojpa.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_patientCosts")
@GenericGenerator(name="jpa-uuid",strategy="uuid")
public class PatientCosts {
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "id", length = 32, nullable = false)
	private String id;
	private String registID;
	private String invoiceID;
	private int itemID;
	private int itemType;
	private String name;
	private double price;
	private double amount;
	private int deptID;
	@Column(name="createtime",nullable=false,length=64)
	private String createtime;
	private int createOperID;
	private String payTime;
	private int registerID;
	private String feeType;
	private int backID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRegistID() {
		return registID;
	}
	public void setRegistID(String registID) {
		this.registID = registID;
	}
	public String getInvoiceID() {
		return invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getCreateOperID() {
		return createOperID;
	}
	public void setCreateOperID(int createOperID) {
		this.createOperID = createOperID;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public int getRegisterID() {
		return registerID;
	}
	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}
	
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public int getBackID() {
		return backID;
	}
	public void setBackID(int backID) {
		this.backID = backID;
	}
	
}
