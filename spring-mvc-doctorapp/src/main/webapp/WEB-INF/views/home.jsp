<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="search">
	
	
		Enter Speciality<input type="text" name="choice"><br>
		<input type="submit" value="Search"></input>
		
		
	</form>
	
	<h2>All Doctors</h2>
	${doctors}
	<h2 style="{color:red}">${message}</h2>
</div>
</body>
</html>