package org.doctorapp.controllers;

import java.sql.SQLException;
import java.util.List;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.exceptions.IdNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {
	
	@Autowired
	private IDoctorService doctorService;
	
	@RequestMapping("/addDoctor")
	public String home(Model model) {
		List<Doctor> doctors = doctorService.getAll();
		model.addAttribute("doctors", doctors);
		return "admin";
	}

	@RequestMapping("/addDoctor")
	public String addDoctor(Doctor doctor) {
		System.out.println(doctor);
		return "admindashboard";
	}
	
	@RequestMapping("/editDoctor")
	public String editDoctor(@RequestParam("doctorId") int doctorId, Model model) throws DoctorNotFoundException, IdNotFoundException {
		Doctor doctor = doctorService.getById(doctorId);
		model.addAttribute("doctor", doctor);
		return "updatedoctorform";
	}
	
	
	@RequestMapping("/updateDoctor")
	public String updateDoctor(@RequestParam("doctorId") int doctorId,
								@RequestParam("fees")double fees, Model model) {
     doctorService.updateDoctor(doctorId,fees);
     model.addAttribute("message", "doctor updated sucessfully");
     return "admindashboardform";
	}

	@RequestMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam("doctorId") int doctorId, Model model) throws DoctorNotFoundException {
		doctorService.deleteDoctor(doctorId);
		model.addAttribute("message", "doctor deleted sucessfully");
		return "admindashboardform";
	}
	
		@RequestMapping("/search")
		public String search(@RequestParam("choice")String choice,Model model) throws DoctorNotFoundException, SQLException {
			List<Doctor> doctors = doctorService.getBySpecialist(choice);
			model.addAttribute("doctors", doctors);
			return "home";
		}

}