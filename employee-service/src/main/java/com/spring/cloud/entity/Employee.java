package com.spring.cloud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.spring.cloud.request.EmployeeRequest;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String position;
	private String address;
	private String nic;
	
	public Employee() {
		super();
	}

	public Employee(String name, int age, String position, String address, String nic) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.address = address;
		this.nic = nic;
	}
	
	public Employee(EmployeeRequest employeeRequest){
		this.name = employeeRequest.getName();
		this.age = employeeRequest.getAge();
		this.position = employeeRequest.getPosition();
		this.address = employeeRequest.getAddress();
		this.nic = employeeRequest.getNic();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
