package org.doctorapp.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.doctorapp.model.Doctor;
import org.doctorapp.util.DoctorDb;
import org.doctorapp.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public abstract class DoctorRepositoryImpl implements IDoctorRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
    @Override
    public void addDoctor(Doctor doctor) {
        try (Connection connection = DoctorDb.OpenConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY)
        ) {
            statement.setInt(1, doctor.getDoctorId());
            statement.setString(2, doctor.getDoctorName());
            statement.setString(3, doctor.getSpeciality());
            statement.setInt(4, doctor.getExperience());
            statement.setDouble(5, doctor.getFees());
            statement.setInt(6, doctor.getRatings());


//            boolean result = statement.execute();
//            System.out.println("One row Inserted "+!result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDoctor(int doctorId, double fees) {
        try (Connection connection = DoctorDb.OpenConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY)
        ) {
            statement.setInt(2, doctorId);
            statement.setDouble(1, fees);

            int result = statement.executeUpdate();
            System.out.println("One row updated " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteDoctor(int doctorId) {
    	jdbcTemplate.update(Queries.DELETEQUERY,doctorId);

    }

    @Override
    public Doctor findById(int doctorId) {
    	Doctor doctor = jdbcTemplate.queryForObject(Queries.FINDALLQUERY,new DoctorMapper(), doctorId);
    	return doctor;
    }

    @Override
    public List<Doctor> findAll() {

        List<Doctor> doctorList = new ArrayList<>();
        try (
                Connection connection = DoctorDb.OpenConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.FINDALLQUERY);
                ResultSet resultSet = statement.executeQuery();
        ) {

            while (resultSet.next()) {
                int doctorId = resultSet.getInt("doctor_Id");
                String doctorName = resultSet.getString("doctor_name");
                String speciality = resultSet.getString("speciality");
                int experience = resultSet.getInt("experience");
                double fees = resultSet.getDouble("fees");
                int ratings = resultSet.getInt("ratings");

                Doctor doctor = new Doctor(doctorId, doctorName, speciality, fees, experience, ratings);
                doctorList.add(doctor);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorList;


    }

    @Override
    public List<Doctor> findBySpecialist(String speciality) throws SQLException {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.OpenConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FINDALLQUERY);) {
            statement.setString(1, speciality);
            try (
                    ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String doctorName = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    int doctorId = resultSet.getInt("doctor_Id");
                    double fees = resultSet.getDouble("fees");

                    Doctor doctor = new Doctor(doctorName, experience, ratings, doctorId, fees);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndExp(String speciality, int experience) {
        List<Doctor> doctorList = new ArrayList<>();
        try (
                Connection connection = DoctorDb.OpenConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.FINDBYSPECANDEX);){
            statement.setString(1,speciality);
            statement.setInt(2,experience);
            try (ResultSet resultSet =statement.executeQuery();){
                while (resultSet.next()){
                    String doctorName = resultSet.getString("doctor_name");
                    int experience1 = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    int doctorId = resultSet.getInt("doctor_Id");
                    double fees = resultSet.getDouble("fees");

                    Doctor doctor = new Doctor(doctorName, experience1, ratings, doctorId, fees);

                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return doctorList;
    }

    @Override
    public List<Doctor> findBySpecialityAndRatings(String speciality, int ratings) {
    	List<Doctor> doctor = jdbcTemplate.query(Queries.FINDBYSPECANDRATINGS, new DoctorMapper(),ratings);
    	return doctor;
    }

    @Override
    public List<Doctor> findBySpecialityAndNameContains(String speciality, String doctorName) {
        List<Doctor> doctorList = new ArrayList<>();
        try (Connection connection = DoctorDb.OpenConnection();
             PreparedStatement statement = connection.prepareStatement(Queries.FINDBYSPECANDNAME);) {
            statement.setString(1, speciality);
            try (
                    ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String doctorName1 = resultSet.getString("doctor_name");
                    int experience = resultSet.getInt("experience");
                    int ratings = resultSet.getInt("ratings");
                    int doctorId = resultSet.getInt("doctor_Id");
                    double fees = resultSet.getDouble("fees");

                    Doctor doctor = new Doctor(doctorName, experience, ratings, doctorId, fees);


                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return doctorList;
    }


    @Override
    public List<Doctor> findBySpecialityAndFees(String speciality, double fees) {
    	List<Doctor> doctor = jdbcTemplate.query(Queries.FINDBYSPECANDFEES, new DoctorMapper(),fees);
    	return doctor;
    }

   
    @Override
    public List<Doctor> Speciality(String speciality) {
    	return jdbcTemplate.query(Queries.FINDBYSPECIALITY, (rs, rowNum)->{
    		Doctor doctor = new Doctor();
    		doctor.setDoctorId(rs.getInt("doctorId"));
    		doctor.setDoctorName(rs.getString("doctorName"));
    		doctor.setSpeciality(rs.getString("speciality"));
    		doctor.setFees(rs.getDouble("fees"));
    		doctor.setRatings(rs.getInt("ratings"));
    		doctor.setExperience(rs.getInt("experience"));
    		return doctor;
    	},speciality);
    }

	

	

	
}