package com.insuranceapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.insuranceapp.exception.InsuranceNotFoundException;
import com.insuranceapp.model.Insurance;

@Mapper
public interface IInsuranceRepository {
	
	@Insert("insert into insurance(insurance_Id,policy_name,brand,type,duration,premium) values(#{insuranceId},#{policyName},#{brand},#{type},#{duration},#{premium})")
	void addInsurance(Insurance insurance);
	
	@Delete("delete from insurance where insurance_Id=#{insuranceId}")
	void updateInsurance(int insuranceId,double premium);
	
	@Select("select * from isurance where insurance_id=#{insuranceId}")
	void deleteInsurance(int insuranceId);
	
	@Select("select * from insurance")
//	@Results({
//			@Results(@Property="insuranceId",column="insurance_Id"),
//			@Results(@Property="policyName",column="policy_name") 
//	})
	
	List<Insurance> findAll();
	
	@Select("select * from insurance where brand=#{brand}")
	List<Insurance> findByBrand(String brand) throws InsuranceNotFoundException;
	
	@Select("select * from insurance where brand=#{price} and type=#{type}")
	List<Insurance> findByBrandAndType(String brand,String type) throws InsuranceNotFoundException;
	
	@Select("select * from insurance where type=#{type} and premium<#{premium} ")
	List<Insurance> findByTypeAndLeesPremium(String type,double premium) throws InsuranceNotFoundException;
	
	@Select("select * from insurance where insurance_id=#{insuranceId}")
	Insurance findById(int insuranceId) throws InsuranceNotFoundException;
}
