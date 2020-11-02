package com.example.demojpa.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_user")
public class User {
	@Id
	private int id;
	private String userName;
	private String password;
	private String realName;
	private int userType;
	private int docTitleID;
	private String isScheduling;
	private int deptID;
	private int registLeID;
	private int delMark = 1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getDocTitleID() {
		return docTitleID;
	}
	public void setDocTitleID(int docTitleID) {
		this.docTitleID = docTitleID;
	}
	public String getIsScheduling() {
		return isScheduling;
	}
	public void setIsScheduling(String isScheduling) {
		this.isScheduling = isScheduling;
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
	public int getDelMark() {
		return delMark;
	}
	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", realName=" + realName
				+ ", userType=" + userType + ", docTitleID=" + docTitleID + ", isScheduling=" + isScheduling
				+ ", deptID=" + deptID + ", registLeID=" + registLeID + ", delMark=" + delMark + "]";
	}
	
	
	
}
