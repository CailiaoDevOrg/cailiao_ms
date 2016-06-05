package com.whut.cailiao.ms.api.model.company;

import java.io.Serializable;

public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer regionId;
	
	private String name;
	
	private String address;
	
	private String postcode;
	
	private int capacity;
	
	private String startDate;
	
	private String endDate;
	
	private String status;
	
	private String phoneNumber;
	
	private int yearCapacity;
	
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getYearCapacity() {
		return yearCapacity;
	}

	public void setYearCapacity(int yearCapacity) {
		this.yearCapacity = yearCapacity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", regionId=" + regionId + ", name=" + name + ", address=" + address
				+ ", postcode=" + postcode + ", capacity=" + capacity + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + ", phoneNumber=" + phoneNumber + ", yearCapacity=" + yearCapacity
				+ ", remark=" + remark + "]";
	}
	
	
	
	
	
	
	
	
}
