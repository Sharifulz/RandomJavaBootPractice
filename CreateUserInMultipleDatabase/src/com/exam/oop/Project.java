package com.exam.oop;

public class Project {

	String companyCode;
	String projectCode;
	String desc;
	
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Project(String companyCode, String projectCode, String desc) {
		super();
		this.companyCode = companyCode;
		this.projectCode = projectCode;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Project [companyCode=" + companyCode + ", projectCode=" + projectCode + ", desc=" + desc + "]";
	}
	
	
}
