<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addDoctor">
	Doctor Name<input type="text" name="doctorname" ></input><br>
	Rating<input type="number" name="rating" ></input><br>
	Experience<input type="number" name="experience" ></input><br>
	Fees<input type="number" name="fees" ></input><br>
	Speciality<input type="text" name="speciality" ></input><br>
	Doctor Speciality
	
	<select name="Speciality">
	<option value="ORTHOPEDIC">ORTHOPEDIC</option>
	<option value="PEDIATRICIAN">PEDIATRICIAN</option>
	<option value="GENERAL PHYSICIAN">GENERAL PHYSICIAN</option>
	<option value="GYNAECOLOGIST">GYNAECOLOGIST</option>
	<option value="NEUROLOGIST">NEUROLOGIST</option>
	<option value="DERMATOLOGIST">DERMATOLOGIST</option>
	<br>
	
	</select>
	
	</form>
</body>
</html>