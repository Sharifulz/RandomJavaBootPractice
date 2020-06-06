package com.ctrends.model;

import java.util.UUID;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UsersModel{

 	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;	//NOT NULL DEFAULT uuid_generate_v4() 

	// -------- Personal identity ----------

	@Column(name = "username")
	private String username;	// login id

	@Column(name = "person_name")
	private String personName;

	@Column(name = "gender")
	private String gender;	//default 'Male' 

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "birth_place")
	private String birthPlace;

	@Column(name = "signup_date")
	private Date signupDate;

	@Column(name = "is_employed")
	private boolean isEmployed;	//default false 

	@Column(name = "occupation")
	private String occupation;	//default 'Business' 	// others: Jobholder

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "desig")
	private String desig;

	// -------- Geo-location parameters ----------

	@Column(name = "home_latitude")
	private double homeLatitude;	//default 23.00 

	@Column(name = "home_logitude")
	private double homeLogitude;	//default 90.00 

	@Column(name = "home_address")
	private String homeAddress;	// current address

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "current_latitude")
	private double currentLatitude;	//default 23.00 

	@Column(name = "current_logitude")
	private double currentLogitude;	//default 90.00 

	@Column(name = "office_latitude")
	private double officeLatitude;	//default 23.00 

	@Column(name = "office_logitude")
	private double officeLogitude;	//default 90.00 

	@Column(name = "office_address")
	private String officeAddress;

	// -------- Identity documents ----------

	@Column(name = "nid_no")
	private String nidNo;

	@Column(name = "is_nid_doc_uploaded")
	private boolean isNidDocUploaded;	//default false 

	@Column(name = "is_nid_no_verified")
	private boolean isNidNoVerified;	//default false 

	@Column(name = "passport_no")
	private String passportNo;

	@Column(name = "passport_issue_place")
	private String passportIssuePlace;

	@Column(name = "nationality")
	private String nationality;	//default 'Bangladesh' 

	@Column(name = "is_passport_doc_uploaded")
	private boolean isPassportDocUploaded;	//default false 

	@Column(name = "is_passport_no_verified")
	private boolean isPassportNoVerified;	//default false 

	@Column(name = "birth_cert_no")
	private String birthCertNo;

	@Column(name = "is_birth_cert_doc_uploaded")
	private boolean isBirthCertDocUploaded;	//default false 

	@Column(name = "is_birth_cert_no_verified")
	private boolean isBirthCertNoVerified;	//default false 

	// -------- Tax matters ----------------

	@Column(name = "tax_no")
	private String taxNo;

	@Column(name = "tax_zone")
	private String taxZone;

	@Column(name = "tax_circle")
	private String taxCircle;

	@Column(name = "is_tax_doc_uploaded")
	private boolean isTaxDocUploaded;	//default false 

	@Column(name = "is_tax_no_verified")
	private boolean isTaxNoVerified;	//default false 

	// -------- Educational information -----

	@Column(name = "ssc_pass_year")
	private int sscPassYear;	//default 1900 

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "is_ssc_cert_uploaded")
	private boolean isSscCertUploaded;	//default false 

	@Column(name = "is_ssc_cert_verified")
	private boolean isSscCertVerified;	//default false 

	@Column(name = "hsc_year")
	private int hscYear;	//default 1900 

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "is_hsc_cert_uploaded")
	private boolean isHscCertUploaded;	//default false 

	@Column(name = "is_hsc_cert_verified")
	private boolean isHscCertVerified;	//default false 

	@Column(name = "bachelor_pass_year")
	private int bachelorPassYear;	//default 1900 

	@Column(name = "bachelor_university_name")
	private String bachelorUniversityName;

	@Column(name = "is_grad_cert_uploaded")
	private boolean isGradCertUploaded;	//default false 

	@Column(name = "is_grad_cert_verified")
	private boolean isGradCertVerified;	//default false 

	@Column(name = "masters_pass_year")
	private int mastersPassYear;	//default 1900 

	@Column(name = "masters_university_name")
	private String mastersUniversityName;

	@Column(name = "is_masters_cert_uploaded")
	private boolean isMastersCertUploaded;	//default false 

	@Column(name = "is_masters_cert_verified")
	private boolean isMastersCertVerified;	//default false 

	// -------- Spouse information ----------

	@Column(name = "spouse_username")
	private String spouseUsername;	// login id of spouse

	@Column(name = "spouse_name")
	private String spouseName;

	@Column(name = "spouse_mobile")
	private String spouseMobile;

	@Column(name = "spouse_email")
	private String spouseEmail;

	@Column(name = "spouse_birth_date")
	private Date spouseBirthDate;

	// -------- Administrative hierarchy ----

	@Column(name = "geography_type")
	private String geographyType;	//DEFAULT 'Rural' 	// Options: Rural, Semi-urban, Urban

	@Column(name = "country_id")
	private UUID countryId;	//default '0b631485-359f-412d-be3e-85a3ddd32ad6' 

	@Column(name = "country_code")
	private String countryCode;	//DEFAULT 'BD' 

	@Column(name = "country_telcode")
	private String countryTelcode;	//DEFAULT '880' 

	@Column(name = "country_name")
	private String countryName;	//DEFAULT 'Bangladesh' 

	@Column(name = "state_id")
	private UUID stateId;	//default '120b16be-3ea3-4976-abfe-380775a44617' 

	@Column(name = "state_code")
	private String stateCode;	//DEFAULT 'BD' 

	@Column(name = "state_name")
	private String stateName;	//DEFAULT 'Bangladesh' 

	@Column(name = "div_id")
	private UUID divId;	//default 'cc8c22e3-8fee-448d-b5a5-52b611ce1fdf' 

	@Column(name = "div_code")
	private String divCode;	//DEFAULT '55' 

	@Column(name = "div_name")
	private String divName;	//DEFAULT 'Rangpur' 

	@Column(name = "district_id")
	private UUID districtId;	//default 'c2ca0894-703e-464a-995c-5bd3f82af235' 

	@Column(name = "district_code")
	private String districtCode;	//DEFAULT '85' 

	@Column(name = "district_name")
	private String districtName;	//DEFAULT 'Rangpur' 

	@Column(name = "subdistrict_id")
	private UUID subdistrictId;	//default '53de4dce-51ab-4064-aee2-6237042c57ee' 

	@Column(name = "subdistrict_code")
	private String subdistrictCode;	//DEFAULT '27' 

	@Column(name = "subdistrict_name")
	private String subdistrictName;	//DEFAULT 'Gangachara' 

	@Column(name = "union_id")
	private UUID unionId;	//default '894360d0-4525-434d-944a-e2c7b4c2f435' 

	@Column(name = "union_code")
	private String unionCode;	//default '31' 

	@Column(name = "union_name")
	private String unionName;	//default 'Gangachara' 

	// -------- Data validation -------------

	@Column(name = "data_digest")
	private String dataDigest;

	@Column(name = "authentication_level")
	private int authenticationLevel;	//default 0 

	@Column(name = "is_enabled")
	private boolean isEnabled;	//default false
	
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

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public double getHomeLatitude() {
		return homeLatitude;
	}

	public void setHomeLatitude(double homeLatitude) {
		this.homeLatitude = homeLatitude;
	}

	public double getHomeLogitude() {
		return homeLogitude;
	}

	public void setHomeLogitude(double homeLogitude) {
		this.homeLogitude = homeLogitude;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public double getCurrentLatitude() {
		return currentLatitude;
	}

	public void setCurrentLatitude(double currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public double getCurrentLogitude() {
		return currentLogitude;
	}

	public void setCurrentLogitude(double currentLogitude) {
		this.currentLogitude = currentLogitude;
	}

	public double getOfficeLatitude() {
		return officeLatitude;
	}

	public void setOfficeLatitude(double officeLatitude) {
		this.officeLatitude = officeLatitude;
	}

	public double getOfficeLogitude() {
		return officeLogitude;
	}

	public void setOfficeLogitude(double officeLogitude) {
		this.officeLogitude = officeLogitude;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getNidNo() {
		return nidNo;
	}

	public void setNidNo(String nidNo) {
		this.nidNo = nidNo;
	}

	public boolean isNidDocUploaded() {
		return isNidDocUploaded;
	}

	public void setNidDocUploaded(boolean isNidDocUploaded) {
		this.isNidDocUploaded = isNidDocUploaded;
	}

	public boolean isNidNoVerified() {
		return isNidNoVerified;
	}

	public void setNidNoVerified(boolean isNidNoVerified) {
		this.isNidNoVerified = isNidNoVerified;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPassportIssuePlace() {
		return passportIssuePlace;
	}

	public void setPassportIssuePlace(String passportIssuePlace) {
		this.passportIssuePlace = passportIssuePlace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public boolean isPassportDocUploaded() {
		return isPassportDocUploaded;
	}

	public void setPassportDocUploaded(boolean isPassportDocUploaded) {
		this.isPassportDocUploaded = isPassportDocUploaded;
	}

	public boolean isPassportNoVerified() {
		return isPassportNoVerified;
	}

	public void setPassportNoVerified(boolean isPassportNoVerified) {
		this.isPassportNoVerified = isPassportNoVerified;
	}

	public String getBirthCertNo() {
		return birthCertNo;
	}

	public void setBirthCertNo(String birthCertNo) {
		this.birthCertNo = birthCertNo;
	}

	public boolean isBirthCertDocUploaded() {
		return isBirthCertDocUploaded;
	}

	public void setBirthCertDocUploaded(boolean isBirthCertDocUploaded) {
		this.isBirthCertDocUploaded = isBirthCertDocUploaded;
	}

	public boolean isBirthCertNoVerified() {
		return isBirthCertNoVerified;
	}

	public void setBirthCertNoVerified(boolean isBirthCertNoVerified) {
		this.isBirthCertNoVerified = isBirthCertNoVerified;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getTaxZone() {
		return taxZone;
	}

	public void setTaxZone(String taxZone) {
		this.taxZone = taxZone;
	}

	public String getTaxCircle() {
		return taxCircle;
	}

	public void setTaxCircle(String taxCircle) {
		this.taxCircle = taxCircle;
	}

	public boolean isTaxDocUploaded() {
		return isTaxDocUploaded;
	}

	public void setTaxDocUploaded(boolean isTaxDocUploaded) {
		this.isTaxDocUploaded = isTaxDocUploaded;
	}

	public boolean isTaxNoVerified() {
		return isTaxNoVerified;
	}

	public void setTaxNoVerified(boolean isTaxNoVerified) {
		this.isTaxNoVerified = isTaxNoVerified;
	}

	public int getSscPassYear() {
		return sscPassYear;
	}

	public void setSscPassYear(int sscPassYear) {
		this.sscPassYear = sscPassYear;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public boolean isSscCertUploaded() {
		return isSscCertUploaded;
	}

	public void setSscCertUploaded(boolean isSscCertUploaded) {
		this.isSscCertUploaded = isSscCertUploaded;
	}

	public boolean isSscCertVerified() {
		return isSscCertVerified;
	}

	public void setSscCertVerified(boolean isSscCertVerified) {
		this.isSscCertVerified = isSscCertVerified;
	}

	public int getHscYear() {
		return hscYear;
	}

	public void setHscYear(int hscYear) {
		this.hscYear = hscYear;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public boolean isHscCertUploaded() {
		return isHscCertUploaded;
	}

	public void setHscCertUploaded(boolean isHscCertUploaded) {
		this.isHscCertUploaded = isHscCertUploaded;
	}

	public boolean isHscCertVerified() {
		return isHscCertVerified;
	}

	public void setHscCertVerified(boolean isHscCertVerified) {
		this.isHscCertVerified = isHscCertVerified;
	}

	public int getBachelorPassYear() {
		return bachelorPassYear;
	}

	public void setBachelorPassYear(int bachelorPassYear) {
		this.bachelorPassYear = bachelorPassYear;
	}

	public String getBachelorUniversityName() {
		return bachelorUniversityName;
	}

	public void setBachelorUniversityName(String bachelorUniversityName) {
		this.bachelorUniversityName = bachelorUniversityName;
	}

	public boolean isGradCertUploaded() {
		return isGradCertUploaded;
	}

	public void setGradCertUploaded(boolean isGradCertUploaded) {
		this.isGradCertUploaded = isGradCertUploaded;
	}

	public boolean isGradCertVerified() {
		return isGradCertVerified;
	}

	public void setGradCertVerified(boolean isGradCertVerified) {
		this.isGradCertVerified = isGradCertVerified;
	}

	public int getMastersPassYear() {
		return mastersPassYear;
	}

	public void setMastersPassYear(int mastersPassYear) {
		this.mastersPassYear = mastersPassYear;
	}

	public String getMastersUniversityName() {
		return mastersUniversityName;
	}

	public void setMastersUniversityName(String mastersUniversityName) {
		this.mastersUniversityName = mastersUniversityName;
	}

	public boolean isMastersCertUploaded() {
		return isMastersCertUploaded;
	}

	public void setMastersCertUploaded(boolean isMastersCertUploaded) {
		this.isMastersCertUploaded = isMastersCertUploaded;
	}

	public boolean isMastersCertVerified() {
		return isMastersCertVerified;
	}

	public void setMastersCertVerified(boolean isMastersCertVerified) {
		this.isMastersCertVerified = isMastersCertVerified;
	}

	public String getSpouseUsername() {
		return spouseUsername;
	}

	public void setSpouseUsername(String spouseUsername) {
		this.spouseUsername = spouseUsername;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseMobile() {
		return spouseMobile;
	}

	public void setSpouseMobile(String spouseMobile) {
		this.spouseMobile = spouseMobile;
	}

	public String getSpouseEmail() {
		return spouseEmail;
	}

	public void setSpouseEmail(String spouseEmail) {
		this.spouseEmail = spouseEmail;
	}

	public Date getSpouseBirthDate() {
		return spouseBirthDate;
	}

	public void setSpouseBirthDate(Date spouseBirthDate) {
		this.spouseBirthDate = spouseBirthDate;
	}

	public String getGeographyType() {
		return geographyType;
	}

	public void setGeographyType(String geographyType) {
		this.geographyType = geographyType;
	}

	public UUID getCountryId() {
		return countryId;
	}

	public void setCountryId(UUID countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryTelcode() {
		return countryTelcode;
	}

	public void setCountryTelcode(String countryTelcode) {
		this.countryTelcode = countryTelcode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public UUID getStateId() {
		return stateId;
	}

	public void setStateId(UUID stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public UUID getDivId() {
		return divId;
	}

	public void setDivId(UUID divId) {
		this.divId = divId;
	}

	public String getDivCode() {
		return divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public String getDivName() {
		return divName;
	}

	public void setDivName(String divName) {
		this.divName = divName;
	}

	public UUID getDistrictId() {
		return districtId;
	}

	public void setDistrictId(UUID districtId) {
		this.districtId = districtId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public UUID getSubdistrictId() {
		return subdistrictId;
	}

	public void setSubdistrictId(UUID subdistrictId) {
		this.subdistrictId = subdistrictId;
	}

	public String getSubdistrictCode() {
		return subdistrictCode;
	}

	public void setSubdistrictCode(String subdistrictCode) {
		this.subdistrictCode = subdistrictCode;
	}

	public String getSubdistrictName() {
		return subdistrictName;
	}

	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}

	public UUID getUnionId() {
		return unionId;
	}

	public void setUnionId(UUID unionId) {
		this.unionId = unionId;
	}

	public String getUnionCode() {
		return unionCode;
	}

	public void setUnionCode(String unionCode) {
		this.unionCode = unionCode;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getDataDigest() {
		return dataDigest;
	}

	public void setDataDigest(String dataDigest) {
		this.dataDigest = dataDigest;
	}

	public int getAuthenticationLevel() {
		return authenticationLevel;
	}

	public void setAuthenticationLevel(int authenticationLevel) {
		this.authenticationLevel = authenticationLevel;
	}

	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public UsersModel() {}



}
