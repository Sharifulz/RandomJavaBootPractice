package com.ctrends.log.model;

import java.util.UUID;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

public class UserErrorLogModel{

	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	// ------- User identity details --------------
 
	private String username;	// this is the user login code

	private String clientCode;

	private String clientName;

	private String companyCode;

	private String companyName;

	private String empCode;

	private String empName;

	private String empDesig;

	private String mobile;

	private String email;

	// ------- Privilege details --------------

	private String suiteCode;

	private String suiteName;

	private String modCode;

	private String modName;

	private String objectCode;

	private String objectName;

	private String actionTypeCode;	//DEFAULT 'LOAD' 	// options: LOGIN, LOGOUT, LOAD, CREATE, EDIT, DELETE, BLOCK, APPROVE, CANCEL

	private String actionTypeName;	//DEFAULT 'Page Load' 	// options: Login, Logout, Page Load, Create, Edit, Delete, Block, Approve, Cancel

	private String objectVisibilityLevel;	//DEFAULT 'Company' 	// options: Company, Client, System

	private String objectComplexibilityLevel;	//DEFAULT 'Moderate' 	// options: Simple, Moderate, Complex

	private int privGrpCode;	//DEFAULT 2 	// Options: 1, 2, 3

	private String privGrpName;	//DEFAULT 'Entry' 	// options: Reporting, Entry, Setup

	private String linkGrpName;

	private int privSeq;	//DEFAULT 1 

	private String privCode;

	private String privName;

	private String tcode;	// shortcut code

	private int serialno;	// an auto-generated serial no. to create an equi-distant performance graph

	// ------- Tracing what was performed -----

	private String description;	// a short narration to describe the transaction

	// ------- Keeping track of time ---------

	private Date actionDate;	// - posting date

	private Timestamp createdAt;	// log posting time

	// -------- User device trace ----------

	private String wsIp;	// user device IP. On the internet, it is the real-ip. In LAN, it is the private IP.

	private String wsName;	// device name

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesig() {
		return empDesig;
	}

	public void setEmpDesig(String empDesig) {
		this.empDesig = empDesig;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSuiteCode() {
		return suiteCode;
	}

	public void setSuiteCode(String suiteCode) {
		this.suiteCode = suiteCode;
	}

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public String getModCode() {
		return modCode;
	}

	public void setModCode(String modCode) {
		this.modCode = modCode;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getObjectCode() {
		return objectCode;
	}

	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getActionTypeCode() {
		return actionTypeCode;
	}

	public void setActionTypeCode(String actionTypeCode) {
		this.actionTypeCode = actionTypeCode;
	}

	public String getActionTypeName() {
		return actionTypeName;
	}

	public void setActionTypeName(String actionTypeName) {
		this.actionTypeName = actionTypeName;
	}

	public String getObjectVisibilityLevel() {
		return objectVisibilityLevel;
	}

	public void setObjectVisibilityLevel(String objectVisibilityLevel) {
		this.objectVisibilityLevel = objectVisibilityLevel;
	}

	public String getObjectComplexibilityLevel() {
		return objectComplexibilityLevel;
	}

	public void setObjectComplexibilityLevel(String objectComplexibilityLevel) {
		this.objectComplexibilityLevel = objectComplexibilityLevel;
	}

	public int getPrivGrpCode() {
		return privGrpCode;
	}

	public void setPrivGrpCode(int privGrpCode) {
		this.privGrpCode = privGrpCode;
	}

	public String getPrivGrpName() {
		return privGrpName;
	}

	public void setPrivGrpName(String privGrpName) {
		this.privGrpName = privGrpName;
	}

	public String getLinkGrpName() {
		return linkGrpName;
	}

	public void setLinkGrpName(String linkGrpName) {
		this.linkGrpName = linkGrpName;
	}

	public int getPrivSeq() {
		return privSeq;
	}

	public void setPrivSeq(int privSeq) {
		this.privSeq = privSeq;
	}

	public String getPrivCode() {
		return privCode;
	}

	public void setPrivCode(String privCode) {
		this.privCode = privCode;
	}

	public String getPrivName() {
		return privName;
	}

	public void setPrivName(String privName) {
		this.privName = privName;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getWsIp() {
		return wsIp;
	}

	public void setWsIp(String wsIp) {
		this.wsIp = wsIp;
	}

	public String getWsName() {
		return wsName;
	}

	public void setWsName(String wsName) {
		this.wsName = wsName;
	}

	public UserErrorLogModel() {
	}



}
