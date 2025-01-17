package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insuranceapp.model.Insurance;

@Service
public class InsuranceSrviceImpl implements IInsuranceService {

	@Override
	public List<Insurance> getAll() {
		// TODO Auto-generated method stub
		return getAllInsurances();
		
	}

	@Override
	public Insurance getById(int insuranceId) {
		// TODO Auto-generated method stub
		List<Insurance> insurances = getAllInsurances();
		for(Insurance insurance:insurances) {
			if(insurance.getInsuranceId()==insuranceId)
				return insurance;
		}
		return null;
		
	}
	
	
	private List<Insurance> getAllInsurances(){
		return Arrays.asList(
				new Insurance(101,"V0-H001","Voya","Health",10,10000),
				new Insurance(102,"BJ-M01","Bajaj","Motar",10,5000),
				new Insurance(103,"FI-Life","Fedility","life",15,8000),
				new Insurance(104,"V0-H001","Voya","Health",10,10000),
				new Insurance(105,"V0-H001","Voya","Health",10,10000)
				
				);
	}
	

}
