package com.insuranceapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;
import com.insuranceapp.repository.IInsuranceRepository;


@Service
public class InsuranceSrviceImpl implements IInsuranceService {
	@Autowired
	IInsuranceRepository iInsuranceRepository;
	@Override
	public void addInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		iInsuranceRepository.addInsurance(insurance);
	}

	@Override
	public void updateInsurance(int insuranceId, double premium) {
		// TODO Auto-generated method stub
		iInsuranceRepository.updateInsurance(insuranceId, premium);
		
	}

	@Override
	public void deleteInsurance(int insuranceId) {
		// TODO Auto-generated method stub
		iInsuranceRepository.deleteInsurance(insuranceId);
		
	}

	@Override
	public List<Insurance> getAll() {
		// TODO Auto-generated method stub
		List<Insurance> insurances = iInsuranceRepository.findAll();
		if(insurances.isEmpty())
			throw new InsuranceNotFoundException();
		return insurances;
	}

	@Override
	public List<Insurance> getByBrand(String brand) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		List<Insurance> insurances = iInsuranceRepository.findByBrand(brand);
		if(insurances.isEmpty())
			throw new InsuranceNotFoundException();
		return insurances;
	}

	@Override
	public List<Insurance> getByBrandAndType(String brand, String type) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		List<Insurance> insurances=iInsuranceRepository.findByBrandAndType(brand,type);
		if(insurances.isEmpty())
			throw new InsuranceNotFoundException();
		return insurances;
		
	}

	@Override
	public List<Insurance> getByTypeAndLeesPremium(String type, double premium) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		List<Insurance> insurances = iInsuranceRepository.findByTypeAndLeesPremium(type,premium);
		return insurances;
	}

	@Override
	public Insurance getById(int insuranceId) throws InsuranceNotFoundException {
		// TODO Auto-generated method stub
		Insurance insurances = iInsuranceRepository.findById(insuranceId);
		if(insurances==null)
			throw new InsuranceNotFoundException();
		return insurances;
	}

	
	
}
