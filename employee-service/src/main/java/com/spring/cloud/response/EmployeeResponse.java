package com.spring.cloud.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.cloud.entity.Employee;

public class EmployeeResponse {
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
	
	public EmployeeResponse(){
		
	}
	public EmployeeResponse(Employee employee){
		this.employeeId = employee.getId();
		this.name = employee.getName();
		this.age = employee.getAge();
		this.position = employee.getPosition();
		this.address = employee.getAddress();
		this.nic = employee.getNic();
	}
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
