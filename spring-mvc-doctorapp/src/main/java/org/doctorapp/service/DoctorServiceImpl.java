package org.doctorapp.service;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.exceptions.IdNotFoundException;
import org.doctorapp.model.Doctor;
import org.doctorapp.repository.DoctorRepositoryImpl;
import org.doctorapp.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
    private IDoctorRepository doctorRepository;
        @Override
        public void addDoctor(Doctor doctor) {
            doctorRepository.addDoctor(doctor);
        }

        @Override
        public void updateDoctor(int doctorId, double fees) {
            doctorRepository.updateDoctor(doctorId,fees);
        }

        @Override
        public void deleteDoctor(int doctorId) {
        	doctorRepository.deleteDoctor(doctorId);
        }

        @Override
        public Doctor getById(int doctorId) throws IdNotFoundException {
            Doctor doctor=doctorRepository.findById(doctorId);
            if(doctor==null)
                throw new IdNotFoundException("Invalid id");
            return doctor;
        }

        @Override
        public List<Doctor> getAll() {
            List<Doctor> doctorList=doctorRepository.findAll();
            return doctorList;
        }

        @Override
        public List<Doctor> getBySpecialist(String speciality) throws DoctorNotFoundException, SQLException {
            return null;
        }

        @Override
        public List<Doctor> Speciality(String speciality) throws DoctorNotFoundException{
            List<Doctor> doctorList=doctorRepository.Speciality(speciality);
            if(doctorList.isEmpty()){
                throw new DoctorNotFoundException("Doctor with this speciality Not Found");
            }
            Collections.sort(doctorList,(d1,d2)->d1.getDoctorName().compareTo(d2.getDoctorName()));
            return doctorList;
        }

        @Override
        public List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException{
            List<Doctor> doctorList=doctorRepository.findBySpecialityAndExp(speciality,experience);
            if(doctorList.isEmpty()){
                throw new DoctorNotFoundException("Doctor with this speciality and experience Not Found");
            }
            Collections.sort(doctorList,(d1,d2)->((Integer)(d2.getExperience())).compareTo(d1.getExperience()));
            return doctorList;
        }

        @Override
        public List<Doctor> getBySpecialityAndLesFees(String speciality, double fees) throws DoctorNotFoundException{

            List<Doctor> doctorList=doctorRepository.getBySpecialityAndLesFees(speciality,fees);
            if(doctorList.isEmpty()){
                throw new DoctorNotFoundException("Doctor with this speciality and less fees Not Found");
            }
            Collections.sort(doctorList,(d1,d2)->((Double)d2.getFees()).compareTo(d1.getFees()));
            return doctorList;
        }

        @Override
        public List<Doctor> getBySpecialityAndRatings(String speciality, int rating) throws DoctorNotFoundException{

            List<Doctor> doctorList=doctorRepository.findBySpecialityAndRatings(speciality,rating);
            if(doctorList.isEmpty()){
                throw new DoctorNotFoundException("Doctor with this speciality and rating Not Found");
            }
            Collections.sort(doctorList,(d1,d2)->((Integer)d2.getRatings()).compareTo(d1.getRatings()));
            return doctorList;
        }

        @Override
        public List<Doctor> getBySpecialityAndNameContains(String speciality, String doctorName)  throws DoctorNotFoundException{
            List<Doctor> doctorList=doctorRepository.findBySpecialityAndNameContains(speciality,doctorName);
            if(doctorList.isEmpty()){
                throw new DoctorNotFoundException("Doctor with this speciality and name Not Found");
            }

            return doctorList;
        }

        @Override
        public List<Doctor> getBySpecialityAndFees(String speciality, double fees) throws DoctorNotFoundException {
            
        	
        	List<Doctor> doctors = doctorRepository.findBySpecialityAndFees(speciality, fees);
        	if(doctors.isEmpty())
        		throw new DoctorNotFoundException("No doctors found");
        	return doctors;
        }

}
