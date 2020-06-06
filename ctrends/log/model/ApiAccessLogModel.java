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


public class ApiAccessLogModel{

 	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	private String attemptOutcome;	//DEFAULT 'Successful' 	// options: Successful, Failure

	private int apiResponseCode;	//DEFAULT 200 	// official record reference no.

	private String description;	// a short narration to describe the transaction

	// ------- Keeping track of time ---------

	private Date actionDate;	// - posting date

	private Timestamp createdAt;	// log posting time

	private Timestamp startTime;	// - when the task started at API server

	private Timestamp endTime;	// - when the task was completed by API server

	private long duration;	//DEFAULT 0 

	// -------- User device trace ----------

	private String registeredIp;

	private String deviceIp;	// user device IP. On the internet, it is the real-ip. In LAN, it is the private IP.

	private String deviceName;	// device name

	private double registeredLatitude;	//DEFAULT 23.0 

	private double registeredLongitude;	//DEFAULT 90.0 

	private double deviceLatitude;	//DEFAULT 23.0 

	private double deviceLongitude;	//DEFAULT 90.0 

	private double distanceFromRegisteredLocKm;	//DEFAULT 0 	// - Calculate this in Km using Haversine formula

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

	public String getAttemptOutcome() {
		return attemptOutcome;
	}

	public void setAttemptOutcome(String attemptOutcome) {
		this.attemptOutcome = attemptOutcome;
	}

	public int getApiResponseCode() {
		return apiResponseCode;
	}

	public void setApiResponseCode(int apiResponseCode) {
		this.apiResponseCode = apiResponseCode;
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

	public String getRegisteredIp() {
		return registeredIp;
	}

	public void setRegisteredIp(String registeredIp) {
		this.registeredIp = registeredIp;
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

	public double getRegisteredLatitude() {
		return registeredLatitude;
	}

	public void setRegisteredLatitude(double registeredLatitude) {
		this.registeredLatitude = registeredLatitude;
	}

	public double getRegisteredLongitude() {
		return registeredLongitude;
	}

	public void setRegisteredLongitude(double registeredLongitude) {
		this.registeredLongitude = registeredLongitude;
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

	public double getDistanceFromRegisteredLocKm() {
		return distanceFromRegisteredLocKm;
	}

	public void setDistanceFromRegisteredLocKm(double distanceFromRegisteredLocKm) {
		this.distanceFromRegisteredLocKm = distanceFromRegisteredLocKm;
	}

	public ApiAccessLogModel() {}

}
