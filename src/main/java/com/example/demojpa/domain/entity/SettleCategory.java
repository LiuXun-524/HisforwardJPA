package com.example.demojpa.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_settleCategory")
public class SettleCategory {
	@Id
	@Column(name="id",nullable=false,length=9)
	private int id;
	@Column(name="settleCode",nullable=false,length=64)
	private String settleCode;	
	@Column(name="settleName",nullable=false,length=64)
	private String settleName;	
	private int sequenceNo;	
	@Column(name="delMark",columnDefinition="int default 1")
	private int delMark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSettleCode() {
		return settleCode;
	}
	public void setSettleCode(String settleCode) {
		this.settleCode = settleCode;
	}
	public String getSettleName() {
		return settleName;
	}
	public void setSettleName(String settleName) {
		this.settleName = settleName;
	}
	public int getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public int getDelMark() {
		return delMark;
	}
	public void setDelMark(int delMark) {
		this.delMark = delMark;
	}
	


}
