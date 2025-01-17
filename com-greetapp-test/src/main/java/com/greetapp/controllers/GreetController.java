package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	//http://localhost:8080/show
	@GetMapping("/show")
	public String showMessage() {
		return "Great Day";
	}
	
	//http://localhost:8080/say-hello/Manu
		@GetMapping("/say-hello/{uname}")
		public String sayHello(@PathVariable("uname") String username) {
					return "Hello"+username;
		}
	
		
		//http://localhost:8080/user-details?name=manu&&city=Kolar
		@GetMapping("/user-details")
		public String showUserDetails(@RequestParam("name") String username,
									@RequestParam("city") String city) {
				return "Welcome "+username+" from "+city;
		}
				
		//http://localhost:8080/show-courses
		@GetMapping("/show-courses")
		public List<String> showCourse() {
				return Arrays.asList("java","Spring","Angular");
		}
			
			
}
