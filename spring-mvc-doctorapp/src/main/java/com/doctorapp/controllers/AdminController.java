package com.doctorapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	
	@RequestMapping("admin")
	public String admin(Model model) {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password) {
		if(username.equals("admin")&& password.equals("admin")) {
			return "admindashboard";
		}
		return "login";
	}
	
	@RequestMapping("add-doctor-form")
	public String adddoctor(Model model) {
		return "adddoctorform";
	}
	
	@RequestMapping("Update-doctor-form")
	public String updatedoctor(Model model) {
		return "updatedoctorform";
	}
	
	@RequestMapping("Delete-doctor-form")
	public String deletedoctor(Model model) {
		return "deletedoctorform";
	}

}
