package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component("shaper")
public class Square implements Shape {

	public void area(int x, int y) {
		// TODO Auto-generated method stub
		
		System.out.println("the area :"+(x*y));
		
	}

}