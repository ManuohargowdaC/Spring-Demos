package com.spring.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private String employeeName;
	private Integer employyeId;
	private Address address;
	public Employee() {
		super();
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	@Value("Ram")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployyeId() {
		return employyeId;
	}
	
	@Value("10")
	public void setEmployyeId(Integer employyeId) {
		this.employyeId = employyeId;
	}
	public Address getAddress() {
		return address;
	}
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employyeId=" + employyeId + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
