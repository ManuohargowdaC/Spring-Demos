package com.voya.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Engine {
	
	double capacity;
	String type;
	
	public double getCapacity() {
		return capacity;
	}
	@Value("250")
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	public String getType() {
		return type;
	}
	@Value("petrol")
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Engine [capacity=" + capacity + ", type=" + type + "]";
	}
		
}
