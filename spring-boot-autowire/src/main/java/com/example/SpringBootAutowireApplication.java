package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.autowiring.ShapeFactory;

@SpringBootApplication

public class SpringBootAutowireApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAutowireApplication.class, args);
	}

	
	@Autowired
	ShapeFactory shapeFactory;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		shapeFactory.printArea("s",10,20);
	}

}
