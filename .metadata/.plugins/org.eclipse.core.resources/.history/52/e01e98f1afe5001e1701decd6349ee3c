package com.spring.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cource {
	private String courceName;
	private double fees;
	
	public Cource() {
		super();
	}
	public Cource(String courceName, double fees) {
		super();
		this.courceName = courceName;
		this.fees = fees;
	}
	public String getCourceName() {
		return courceName;
	}
	@Value("${student.cource.cource}")
	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}
	
	public double getFees() {
		return fees;
	}
	@Value("${student.cource.fees}")
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Cource [courceName=" + courceName + ", fees=" + fees + "]";
	}
	
	

}
