package com.spring.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

	public void area(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("the area :"+(x*y));
		
	}
	
}
