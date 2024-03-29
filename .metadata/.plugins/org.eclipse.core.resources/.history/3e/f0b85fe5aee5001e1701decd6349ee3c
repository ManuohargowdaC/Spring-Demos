package com.spring.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Student {
	
	private String studentName;
	private Integer studentId;
	private Cource cource;
	
	
	

	


	public Student(Cource cource) {
		super();
		this.cource = cource;
	}



	public String getStudentName() {
		return studentName;
	}



	@Value("${student.studentName}")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}




	public Integer getStudentId() {
		return studentId;
	}



	@Value("${student.studentId}")
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}





	



	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", cource=" + cource + "]";
	}


	
	
	
	

}
