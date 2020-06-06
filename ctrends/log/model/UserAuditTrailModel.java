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

public class UserAuditTrailModel{

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

	private String locationCode;

	private String locationName;

	private String addr;

	private String floorCode;

	private String floorName;

	private String roomCode;

	private String roomName;

	private String seatCode;

	private String seatName;

	// ------- Reporting manager --------------

	private String rmEmpCode;

	private String rmEmpName;

	private String rmEmpDesig;

	private String rmMobile;

	private String rmEmail;

	// ------- Map information ----------------

	private double officeLatitude;	//DEFAULT 23.0 	// - this is the office location of the user

	private double officeLongitude;	//DEFAULT 90.0 

	private double deviceLatitude;	//DEFAULT 23.0 	// - this is the exact location of the user device

	private double deviceLongitude;	//DEFAULT 90.0 

	private double userDistanceFromOfficeKm;	//DEFAULT 0 	// - Calculate this in Km using Haversine formula

	// ------- Privilege details --------------

	private String suiteCode;

	private String suiteName;

	private UUID modId;

	private String modCode;

	private String modShortName;

	private String modFullName;

	private int modSeq;	//DEFAULT 1 

	private String objectCode;

	private String objectName;

	private String actionTypeCode;	//DEFAULT 'LOAD' 	// options: LOGIN, LOGOUT, LOAD, CREATE, EDIT, DELETE, BLOCK, APPROVE, CANCEL

	private String actionTypeName;	//DEFAULT 'Page Load' 	// options: Login, Logout, Page Load, Create, Edit, Delete, Block, Approve, Cancel

	private String objectVisibilityLevel;	//DEFAULT 'Company' 	// options: Company, Client, System

	private String objectComplexibilityLevel;	//DEFAULT 'Moderate' 	// options: Simple, Moderate, Complex

	private int privGrpCode;	//DEFAULT 2 	// Options: 1, 2, 3

	private String privGrpName;	//DEFAULT 'Entry' 	// options: Reporting, Entry, Setup

	private String linkGrpName;

	private UUID privId;

	private int privSeq;	//DEFAULT 1 

	private String privCode;

	private String privName;

	private String tcode;	// shortcut code

	private boolean isAutoGranted;	//DEFAULT false 

	private int serialno;	// an auto-generated serial no. to create an equi-distant performance graph

	// ------- Tracing what was performed -----

	private String attemptOutcome;	//DEFAULT 'Successful' 	// options: Successful, Failure

	private UUID transactionId;	// internal UUID of the record (the id field-value)

	private int transactionRefNo;	// official record reference no.

	private String transactionTypeCode;	// trans type / doa type code

	private String transactionTypeName;	// trans type / doa type

	private String description;	// a short narration to describe the transaction

	// ------- Keeping track of time ---------

	private Date actionDate;	// - posting date

	private Timestamp createdAt;	// log posting time

	private Timestamp startTime;	// - when the task started at web server

	private Timestamp endTime;	// - when the user app or browser shows completion notification / page loaded

	private long duration;	//DEFAULT 0 	// - it is the response time in ms = server_duration + network_duration + client_duration

	private long serverDuration;	//DEFAULT 0 	// time in ms taken by the web server to process

	private long networkDuration;	//DEFAULT 0 	// time in ms taken to travel thru the network from web server to client device

	private long clientDuration;	//DEFAULT 0 	// time in ms taken by client app to render the page & display to user

	private long turnaroundTime;	//DEFAULT 0 	// - it is TAT in ms = server_duration + 2*network_duration + client_duration

	// -------- User device trace ----------

	private String wsIp;	// user device IP. On the internet, it is the real-ip. In LAN, it is the private IP.

	private String wsName;	// device name

	private String wsMac;	// device MAC (NIC L2 address)

	private String userAgent;	// browser name

	private String os;	// OS name, e.g., Windows 10

	private boolean isOtpUsed;	//DEFAULT false 

	// -------- Server load and resource at that time ---------------------------------

	private long onlineUsers;	//DEFAULT 1 	// how many users were online at that time

	private long webserverCpuCores;	//DEFAULT 0 ---- Web server processor cores at that time 

	private long webserverRamGb;	//DEFAULT 4  ---- Server RAM in GB at that time 

	private long webserverHddTb;	//DEFAULT 0  ---- Web server HDD storage in TB at that time 

	private long dbserverCpuCores;	//DEFAULT 0 ---- Web server processor cores at that time 

	private long dbserverRamGb;	//DEFAULT 4  ---- Server RAM in GB at that time 

	private long dbserverHddTb;	//DEFAULT 0  ---- Web server HDD storage in TB at that time 

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

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getRmEmpCode() {
		return rmEmpCode;
	}

	public void setRmEmpCode(String rmEmpCode) {
		this.rmEmpCode = rmEmpCode;
	}

	public String getRmEmpName() {
		return rmEmpName;
	}

	public void setRmEmpName(String rmEmpName) {
		this.rmEmpName = rmEmpName;
	}

	public String getRmEmpDesig() {
		return rmEmpDesig;
	}

	public void setRmEmpDesig(String rmEmpDesig) {
		this.rmEmpDesig = rmEmpDesig;
	}

	public String getRmMobile() {
		return rmMobile;
	}

	public void setRmMobile(String rmMobile) {
		this.rmMobile = rmMobile;
	}

	public String getRmEmail() {
		return rmEmail;
	}

	public void setRmEmail(String rmEmail) {
		this.rmEmail = rmEmail;
	}

	public double getOfficeLatitude() {
		return officeLatitude;
	}

	public void setOfficeLatitude(double officeLatitude) {
		this.officeLatitude = officeLatitude;
	}

	public double getOfficeLongitude() {
		return officeLongitude;
	}

	public void setOfficeLongitude(double officeLongitude) {
		this.officeLongitude = officeLongitude;
	}

	public double getDeviceLatitude() {
		return deviceLatitude;
	}

	public void setDeviceLatitude(double deviceLatitude) {
		this.deviceLatitude = deviceLatitude;
	}

	public double getDeviceLongitude() {
		return deviceLongitude;
	}

	public void setDeviceLongitude(double deviceLongitude) {
		this.deviceLongitude = deviceLongitude;
	}

	public double getUserDistanceFromOfficeKm() {
		return userDistanceFromOfficeKm;
	}

	public void setUserDistanceFromOfficeKm(double userDistanceFromOfficeKm) {
		this.userDistanceFromOfficeKm = userDistanceFromOfficeKm;
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

	public UUID getModId() {
		return modId;
	}

	public void setModId(UUID modId) {
		this.modId = modId;
	}

	public String getModCode() {
		return modCode;
	}

	public void setModCode(String modCode) {
		this.modCode = modCode;
	}

	public String getModShortName() {
		return modShortName;
	}

	public void setModShortName(String modShortName) {
		this.modShortName = modShortName;
	}

	public String getModFullName() {
		return modFullName;
	}

	public void setModFullName(String modFullName) {
		this.modFullName = modFullName;
	}

	public int getModSeq() {
		return modSeq;
	}

	public void setModSeq(int modSeq) {
		this.modSeq = modSeq;
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

	public UUID getPrivId() {
		return privId;
	}

	public void setPrivId(UUID privId) {
		this.privId = privId;
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

	public boolean isAutoGranted() {
		return isAutoGranted;
	}

	public void setAutoGranted(boolean isAutoGranted) {
		this.isAutoGranted = isAutoGranted;
	}

	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	public String getAttemptOutcome() {
		return attemptOutcome;
	}

	public void setAttemptOutcome(String attemptOutcome) {
		this.attemptOutcome = attemptOutcome;
	}

	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	public int getTransactionRefNo() {
		return transactionRefNo;
	}

	public void setTransactionRefNo(int transactionRefNo) {
		this.transactionRefNo = transactionRefNo;
	}

	public String getTransactionTypeCode() {
		return transactionTypeCode;
	}

	public void setTransactionTypeCode(String transactionTypeCode) {
		this.transactionTypeCode = transactionTypeCode;
	}

	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
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

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getServerDuration() {
		return serverDuration;
	}

	public void setServerDuration(long serverDuration) {
		this.serverDuration = serverDuration;
	}

	public long getNetworkDuration() {
		return networkDuration;
	}

	public void setNetworkDuration(long networkDuration) {
		this.networkDuration = networkDuration;
	}

	public long getClientDuration() {
		return clientDuration;
	}

	public void setClientDuration(long clientDuration) {
		this.clientDuration = clientDuration;
	}

	public long getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(long turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
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

	public String getWsMac() {
		return wsMac;
	}

	public void setWsMac(String wsMac) {
		this.wsMac = wsMac;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public boolean isOtpUsed() {
		return isOtpUsed;
	}

	public void setOtpUsed(boolean isOtpUsed) {
		this.isOtpUsed = isOtpUsed;
	}

	public long getOnlineUsers() {
		return onlineUsers;
	}

	public void setOnlineUsers(long onlineUsers) {
		this.onlineUsers = onlineUsers;
	}

	public long getWebserverCpuCores() {
		return webserverCpuCores;
	}

	public void setWebserverCpuCores(long webserverCpuCores) {
		this.webserverCpuCores = webserverCpuCores;
	}

	public long getWebserverRamGb() {
		return webserverRamGb;
	}

	public void setWebserverRamGb(long webserverRamGb) {
		this.webserverRamGb = webserverRamGb;
	}

	public long getWebserverHddTb() {
		return webserverHddTb;
	}

	public void setWebserverHddTb(long webserverHddTb) {
		this.webserverHddTb = webserverHddTb;
	}

	public long getDbserverCpuCores() {
		return dbserverCpuCores;
	}

	public void setDbserverCpuCores(long dbserverCpuCores) {
		this.dbserverCpuCores = dbserverCpuCores;
	}

	public long getDbserverRamGb() {
		return dbserverRamGb;
	}

	public void setDbserverRamGb(long dbserverRamGb) {
		this.dbserverRamGb = dbserverRamGb;
	}

	public long getDbserverHddTb() {
		return dbserverHddTb;
	}

	public void setDbserverHddTb(long dbserverHddTb) {
		this.dbserverHddTb = dbserverHddTb;
	}

	public UserAuditTrailModel() {
		super();
	}

	

}
