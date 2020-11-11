package com.example.demojpa.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_register")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Register {
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "id", length = 32, nullable = false)
	private String id;
	
	@Transient
	private String invoiceNum;
	
	private int caseNumber;
	
	@Column(name = "realName", nullable = false, length = 64)
	private String realName;
	
	private String iDNumber;
	
	@Column(name = "birthDate", nullable = false, length = 64)
	private String birthDate;
	
	private int gender;
	
	private int age;
	
	private char ageType;
	
	@Column(name = "homeAddress", nullable = false, length = 64)
	private String homeAddress;
	
	@Column(name = "settleID", nullable = false, length = 64)
	private String settleID;
	
	@Column(name = "visitDate", nullable = false, length = 64)
	private String visitDate;
	
	@Column(name = "registTime", nullable = false, length = 64)
	private String registTime;
	
	@Column(name = "noon", nullable = false, length = 64)
	private String noon;
	
	private int deptID;
	
	private int registLeID;
	
	private int userID;
	
	@Transient
	private int startNum;
	@Transient
	private int usedNum;
	
	private int isBook;
	@Transient
	private double registFee;
	@Transient
	private String payType;
	
    private int visitState=1;

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

	public int getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(int caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	

	public String getiDNumber() {
		return iDNumber;
	}

	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getAgeType() {
		return ageType;
	}

	public void setAgeType(char ageType) {
		this.ageType = ageType;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getSettleID() {
		return settleID;
	}

	public void setSettleID(String settleID) {
		this.settleID = settleID;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}

	public String getNoon() {
		return noon;
	}

	public void setNoon(String noon) {
		this.noon = noon;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public int getRegistLeID() {
		return registLeID;
	}

	public void setRegistLeID(int registLeID) {
		this.registLeID = registLeID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getUsedNum() {
		return usedNum;
	}

	public void setUsedNum(int usedNum) {
		this.usedNum = usedNum;
	}

	public int getIsBook() {
		return isBook;
	}

	public void setIsBook(int isBook) {
		this.isBook = isBook;
	}

	public double getRegistFee() {
		return registFee;
	}

	public void setRegistFee(double registFee) {
		this.registFee = registFee;
	}


	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}


	public int getVisitState() {
		return visitState;
	}

	public void setVisitState(int visitState) {
		this.visitState = visitState;
	}

	
    
    
	
}
