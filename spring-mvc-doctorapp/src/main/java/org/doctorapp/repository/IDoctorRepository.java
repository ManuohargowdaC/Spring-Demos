package org.doctorapp.repository;

import java.sql.SQLException;
import java.util.List;

import org.doctorapp.model.Doctor;

public interface IDoctorRepository {

    void addDoctor(Doctor doctor);
    void updateDoctor(int doctorId,double fees);
    void deleteDoctor(int doctorId);


    Doctor findById(int doctorId);
    List<Doctor> findAll();
    List<Doctor> findBySpecialist(String speciality) throws SQLException;
    List<Doctor> findBySpecialityAndExp(String speciality,int experience);
    List<Doctor> findBySpecialityAndRatings(String speciality,int ratings);
    List<Doctor> findBySpecialityAndNameContains(String speciality,String doctorName);
    List<Doctor> findBySpecialityAndFees(String speciality,double fees);


    List<Doctor> getBySpecialityAndLesFees(String speciality, double fees);

    List<Doctor> Speciality(String speciality);
	Doctor findById1(int doctorId);
}
