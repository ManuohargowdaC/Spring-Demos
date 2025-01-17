package org.doctorapp.service;

import java.sql.SQLException;
import java.util.List;

import org.doctorapp.exceptions.DoctorNotFoundException;
import org.doctorapp.exceptions.IdNotFoundException;
import org.doctorapp.model.Doctor;

public interface IDoctorService {
    void addDoctor(Doctor doctor);
    void updateDoctor(int doctorId,double fees);
    void deleteDoctor(int doctorId) throws DoctorNotFoundException;


    Doctor getById(int doctorId) throws DoctorNotFoundException, IdNotFoundException;
    List<Doctor> getAll();
    List<Doctor> getBySpecialist(String speciality) throws DoctorNotFoundException, SQLException;

    List<Doctor> Speciality(String speciality) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndExp(String speciality, int experience) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndLesFees(String speciality, double fees) throws DoctorNotFoundException;

    List<Doctor> getBySpecialityAndRatings(String speciality, int ratings) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndNameContains(String speciality,String doctorName) throws DoctorNotFoundException;
    List<Doctor> getBySpecialityAndFees(String speciality,double fees) throws DoctorNotFoundException;


}
