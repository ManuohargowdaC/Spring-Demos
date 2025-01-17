package com.insuranceapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.service.IInsuranceService;

@RestController
@RequestMapping("/insurance-api/v1")
public class InsuranceControllers {
	
	@Autowired
	IInsuranceService iInsuranceService;
	
	@PostMapping("/insurances")
	ResponseEntity<Void> addInsurance(@RequestBody Insurance insurance) {
		iInsuranceService.addInsurance(insurance);
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
	}
	
	@PutMapping("/insurances")
	ResponseEntity<Void> updateInsurance(@RequestBody Insurance insurance) {
		iInsuranceService.updateInsurance(insurance.getInsuranceId(), insurance.getPremium());
		return ResponseEntity.accepted().build();
	}
	
	@DeleteMapping("/insurances/insurance-id/{insuranceId}")
	ResponseEntity<Void> deleteInsurance(int insuranceId) {
		iInsuranceService.deleteInsurance(insuranceId);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/insurances")
	ResponseEntity<List<Insurance>> getAll(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("info","returning list of insurance");
		headers.add("desc","All insurance from DB");
		List<Insurance> insurances = iInsuranceService.getAll();
		ResponseEntity<List<Insurance>> entity = new ResponseEntity<>(insurances, headers, HttpStatus.OK);
		
				
		return entity;
	}
	 
	@GetMapping("/insurances/brand/{brand}")
	List<Insurance> getByBrand(@PathVariable("brand") String brand){
		return iInsuranceService.getByBrand(brand);
	}
	
	@GetMapping("/insurances/brand/{brand}/type/{type}")
	ResponseEntity<List<Insurance>> getByBrandAndType(@PathVariable("brand") String brand,
			@PathVariable("type") String type){
		List<Insurance> insurances = iInsuranceService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info","returning list of insurance by Brand");
		return ResponseEntity.status(200).headers(headers).body(insurances);
		
	} 
	
	@GetMapping("/insurances/type-premium")
	ResponseEntity<List<Insurance>> getByTypeAndLeesPremium(@PathVariable("type") String type,
			@PathVariable("premium") double premium){
		List<Insurance> insurances = iInsuranceService.getByTypeAndLeesPremium(type, premium);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info","returning list of insurance by type And Premium");
		return ResponseEntity.accepted().headers(headers).body(insurances);
		
	}
	
	@GetMapping("/insurances/insurance-id")
	ResponseEntity<Insurance> getById(@PathVariable("insuranceId") int insuranceId) {
		Insurance insurance = iInsuranceService.getById(insuranceId);
		return ResponseEntity.ok().body(insurance);
	}
}
	


