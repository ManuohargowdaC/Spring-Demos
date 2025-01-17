package com.productapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappMybatisApplication.class, args);
	}
	@Autowired
	IProductService productService;

	public void run(String... args) throws Exception {
		
		List<Product> products=productService.getAll();
		for(Product product:products) {
			System.out.println(product);
		}		

	}
}
