package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner {
	
	@Autowired
	private IBookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println();
		bookService.getAll().forEach(System.out::println);
		System.out.println();
		bookService.getByAuthorStartsWith("Robin").forEach(System.out::println);
		System.out.println();
		bookService.getByPriceLessThan(2000).forEach(System.out::println);
		System.out.println();
		System.out.println(bookService.getById(1));
		
	}

}
