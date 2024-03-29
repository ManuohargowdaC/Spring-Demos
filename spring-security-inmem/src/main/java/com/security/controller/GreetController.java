package com.security.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class GreetController {

	//http://localhost:8080/greet
	@GetMapping("/greet")
	public String greet() {
		return "Have a good Day";
	}
	
	//http://localhost:8080/say-hello/Manu
	@GetMapping("/admin/books/show")
	public String addBooks() {
			return "added";
	}
		
		
				
		//http://localhost:8080/show-courses
		@GetMapping("/user/books/show")
		public List<String> showBooks() {
				return Arrays.asList("java","Spring","Angular");
		}
			
			

}
