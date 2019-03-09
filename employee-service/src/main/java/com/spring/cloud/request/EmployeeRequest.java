package com.spring.cloud.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
	@JsonProperty("employee_id")
	private int employeeId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("age")
	private int age;
	@JsonProperty("position")
	private String position;
	@JsonProperty("address")
	private String address;
	@JsonProperty("nic")
	private String nic;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
}
