package com.insuranceapp.model;

import java.util.List;

public class AppUser {
	private String userName;
	private int userId;
	private String password;
	private String email;
	private List<String> role;
	
	
	public AppUser() {
		super();
	}


	public AppUser(String userName, int userId, String password, String email, List<String> role) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<String> getRole() {
		return role;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "AppUser [userName=" + userName + ", userId=" + userId + ", password=" + password + ", email=" + email
				+ ", role=" + role + "]";
	}
	
	
	

}
