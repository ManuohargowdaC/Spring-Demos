package com.spring.autowiring;



import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class AutoMain {
	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.autowiring");
		ShapeFactory shapeFactory =context.getBean("shapeFactory",ShapeFactory.class);
		shapeFactory.printArea("t", 10, 20);
		
	}
	

}
