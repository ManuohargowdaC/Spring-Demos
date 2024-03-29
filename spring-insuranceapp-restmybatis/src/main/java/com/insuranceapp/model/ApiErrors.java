package com.insuranceapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	
	
	private LocalDateTime timestamp;
	private int stausCode;
	private String error;
	private HttpStatus status;
	
	
	public ApiErrors() {
		super();
	}
	
	public ApiErrors( LocalDateTime timestamp, int stausCode, String error, HttpStatus status) {
		super();
		
		this.timestamp = timestamp;
		this.stausCode = stausCode;
		this.error = error;
		this.status = status;
	}
	
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStausCode() {
		return stausCode;
	}
	public void setStausCode(int stausCode) {
		this.stausCode = stausCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiErrors [ timestamp=" + timestamp + ", stausCode=" + stausCode + ", error="
				+ error + ", status=" + status + "]";
	}
		
	

}
