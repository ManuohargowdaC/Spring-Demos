package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Shape{

	public void area(int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("the area of Rectangle is :"+(x*y));
		
	}
	


}
