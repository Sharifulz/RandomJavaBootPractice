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

public class ApiErrorLogModel{

	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	// ------- API client identity details --------------

	private String clientCode;	//DEFAULT 'BDA' 

	private String clientName;	//DEFAULT 'Bangladesh Army' 

	// ------- API details --------------

	private String appCode;	//DEFAULT 'GIS' 

	private String appName;	//DEFAULT 'Web GIS' 

	private String apiEndpoint;	//DEFAULT '/get_union_by_id/{id}' 

	private String apiPathWithParams;	//DEFAULT '/get_union_by_id/234-ds23-adfa-24124?api_key=123456789' 

	private int serialno;	// an auto-generated serial no. to create an equi-distant performance graph

	// ------- Tracing what was performed -----

	private String description;	// a copy of the exception details

	// ------- Keeping track of time ---------

	private Date actionDate;	// - posting date

	private Timestamp createdAt;	// log posting time

	// -------- User device trace ----------

	private String deviceIp;	// user device IP. On the internet, it is the real-ip. In LAN, it is the private IP.

	private String deviceName;	// device name

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getApiEndpoint() {
		return apiEndpoint;
	}

	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}

	public String getApiPathWithParams() {
		return apiPathWithParams;
	}

	public void setApiPathWithParams(String apiPathWithParams) {
		this.apiPathWithParams = apiPathWithParams;
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

	
	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public ApiErrorLogModel() {}


}
