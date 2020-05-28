package com.exam.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "gis_unions")
public class GisUnionModel{

	@Id
	@Column(name = "id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	UUID id;

	@Column(name = "country_id")
	UUID countryId;

	@Column(name = "country_code")
	String countryCode;

	@Column(name = "country_name")
	String countryName;

	@Column(name = "state_id")
	UUID stateId;

	@Column(name = "state_code")
	String stateCode;

	@Column(name = "state_name")
	String stateName;

	@Column(name = "div_id")
	UUID divId;

	@Column(name = "div_code")
	String divCode;

	@Column(name = "div_name")
	String divName;

	@Column(name = "district_id")
	UUID districtId;

	@Column(name = "district_code")
	String districtCode;

	@Column(name = "district_name")
	String districtName;

	@Column(name = "subdistrict_id")
	UUID subdistrictId;

	@Column(name = "subdistrict_code")
	String subdistrictCode;

	@Column(name = "subdistrict_name")
	String subdistrictName;

	@Column(name = "union_type")
	String unionType;

	@Column(name = "union_code")
	String unionCode;

	@Column(name = "union_name")
	String unionName;

	@Column(name = "area_skm")
	long areaSkm;

	@Column(name = "office_latitude")
	double officeLatitude;

	@Column(name = "office_longitude")
	double officeLongitude;

	@Column(name = "office_phone")
	String officePhone;

	@Column(name = "office_email")
	String officeEmail;

	@Column(name = "office_website")
	String officeWebsite;

	@Column(name = "office_address")
	String officeAddress;

	@Column(name = "local_lang_name")
	String localLangName;

	@Column(name = "office_incharge")
	String officeIncharge;

	@Column(name = "total_population")
	long totalPopulation;

	@Column(name = "population_male")
	long populationMale;

	@Column(name = "population_female")
	long populationFemale;

	@Column(name = "young_boys")
	long youngBoys;

	@Column(name = "young_girls")
	long youngGirls;

	@Column(name = "trans_gender")
	long transGender;

	@Column(name = "employed_male")
	long employedMale;

	@Column(name = "employed_female")
	long employedFemale;

	@Column(name = "unemployed_male")
	long unemployedMale;

	@Column(name = "unemployed_female")
	long unemployedFemale;

	@Column(name = "educated_male")
	long educatedMale;

	@Column(name = "educated_female")
	long educatedFemale;

	@Column(name = "boundary_array")
	String boundaryArray;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getUnionType() {
		return unionType;
	}

	public void setUnionType(String unionType) {
		this.unionType = unionType;
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

	public long getAreaSkm() {
		return areaSkm;
	}

	public void setAreaSkm(long areaSkm) {
		this.areaSkm = areaSkm;
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

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficeEmail() {
		return officeEmail;
	}

	public void setOfficeEmail(String officeEmail) {
		this.officeEmail = officeEmail;
	}

	public String getOfficeWebsite() {
		return officeWebsite;
	}

	public void setOfficeWebsite(String officeWebsite) {
		this.officeWebsite = officeWebsite;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getLocalLangName() {
		return localLangName;
	}

	public void setLocalLangName(String localLangName) {
		this.localLangName = localLangName;
	}

	public String getOfficeIncharge() {
		return officeIncharge;
	}

	public void setOfficeIncharge(String officeIncharge) {
		this.officeIncharge = officeIncharge;
	}

	public long getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(long totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	public long getPopulationMale() {
		return populationMale;
	}

	public void setPopulationMale(long populationMale) {
		this.populationMale = populationMale;
	}

	public long getPopulationFemale() {
		return populationFemale;
	}

	public void setPopulationFemale(long populationFemale) {
		this.populationFemale = populationFemale;
	}

	public long getYoungBoys() {
		return youngBoys;
	}

	public void setYoungBoys(long youngBoys) {
		this.youngBoys = youngBoys;
	}

	public long getYoungGirls() {
		return youngGirls;
	}

	public void setYoungGirls(long youngGirls) {
		this.youngGirls = youngGirls;
	}

	public long getTransGender() {
		return transGender;
	}

	public void setTransGender(long transGender) {
		this.transGender = transGender;
	}

	public long getEmployedMale() {
		return employedMale;
	}

	public void setEmployedMale(long employedMale) {
		this.employedMale = employedMale;
	}

	public long getEmployedFemale() {
		return employedFemale;
	}

	public void setEmployedFemale(long employedFemale) {
		this.employedFemale = employedFemale;
	}

	public long getUnemployedMale() {
		return unemployedMale;
	}

	public void setUnemployedMale(long unemployedMale) {
		this.unemployedMale = unemployedMale;
	}

	public long getUnemployedFemale() {
		return unemployedFemale;
	}

	public void setUnemployedFemale(long unemployedFemale) {
		this.unemployedFemale = unemployedFemale;
	}

	public long getEducatedMale() {
		return educatedMale;
	}

	public void setEducatedMale(long educatedMale) {
		this.educatedMale = educatedMale;
	}

	public long getEducatedFemale() {
		return educatedFemale;
	}

	public void setEducatedFemale(long educatedFemale) {
		this.educatedFemale = educatedFemale;
	}

	public String getBoundaryArray() {
		return boundaryArray;
	}

	public void setBoundaryArray(String boundaryArray) {
		this.boundaryArray = boundaryArray;
	}



}
