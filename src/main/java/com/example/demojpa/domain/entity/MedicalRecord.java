package com.example.demojpa.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_medicalRecord")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class MedicalRecord {
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "id", length = 32, nullable = false)
	private String id;
	@Column(name = "caseNumber", length = 32, nullable = false)
	private String caseNumber;//病历号
	@Column(name = "registID", length = 32, nullable = false)
	private String registID	;//挂号ID
	@Column(name = "readme", length = 512)
	private String readme;//主诉
	@Column(name = "present", length = 512)
	private String present;//现病史
	@Column(name = "presentTreat", length = 512)
	private String presentTreat;//现病治疗情况
	@Column(name = "history", length = 512)
	private String history;//既往史
	@Column(name = "allergy", length = 512)
	private String allergy;//过敏史
	@Column(name = "physique", length = 512)
	private String physique;//体格检查
	@Column(name = "proposal", length = 512)
	private String proposal;//检察建议
	@Column(name = "careful", length = 512)
	private String careful;//注意事项
	@Column(name = "checkResult", length = 512)
	private String checkResult;//检查结果
	@Column(name = "diagnosis", length = 512)
	private String diagnosis;//诊断结果
	@Column(name = "handling", length = 512)
	private String handling;//处理意见
	private int caseState=1;//病理状态：1-暂存 2-已提交 3-诊必
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getRegistID() {
		return registID;
	}
	public void setRegistID(String registID) {
		this.registID = registID;
	}
	public String getReadme() {
		return readme;
	}
	public void setReadme(String readme) {
		this.readme = readme;
	}
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getPresentTreat() {
		return presentTreat;
	}
	public void setPresentTreat(String presentTreat) {
		this.presentTreat = presentTreat;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public String getPhysique() {
		return physique;
	}
	public void setPhysique(String physique) {
		this.physique = physique;
	}
	public String getProposal() {
		return proposal;
	}
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	public String getCareful() {
		return careful;
	}
	public void setCareful(String careful) {
		this.careful = careful;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getHandling() {
		return handling;
	}
	public void setHandling(String handling) {
		this.handling = handling;
	}
	public int getCaseState() {
		return caseState;
	}
	public void setCaseState(int caseState) {
		this.caseState = caseState;
	}
	
	
}
