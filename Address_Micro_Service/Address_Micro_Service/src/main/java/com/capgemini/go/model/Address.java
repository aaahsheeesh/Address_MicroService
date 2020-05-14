package com.capgemini.go.model;

import javax.persistence.Column;
import javax.persistence.Entity;  

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;


import com.sun.istack.NotNull; 

@Entity  
public class Address {
	

	@Id  
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private long addressId;
	@SuppressWarnings("unused")
	private String retailerID;
	@NotNull
	@NotBlank(message = "mandatory")
	private String buildingNo;
	@NotNull
	@NotBlank(message = "mandatory")
	private String city;
	@NotNull
	@NotBlank(message = "mandatory")
	private String state;
	@NotBlank(message = "mandatory")
	private String field;
	@NotNull
	@NotBlank(message = "mandatory")
	private String zip;
	
	
	public Address() {
		super();}
	
	
	 @Column(name = "addressId", nullable = false)
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	 @Column(name = "buildingNo", nullable = false)
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	 @Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	 @Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	 @Column(name = "field", nullable = false)
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	 @Column(name = "zip", nullable = false)
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", buildingNo=" + buildingNo + ", city=" + city + ", state=" + state
				+ ", field=" + field + ", zip=" + zip + "]";
	}
	public Address(int addressId, String buildingNo, String city, String state, String field, String zip) {
		super();
		this.addressId = addressId;
		this.buildingNo = buildingNo;
		this.city = city;
		this.state = state;
		this.field = field;
		this.zip = zip;
	}
	
}
