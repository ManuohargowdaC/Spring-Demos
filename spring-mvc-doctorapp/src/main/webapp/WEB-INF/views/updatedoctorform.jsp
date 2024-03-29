<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">


Enter doctorName<input type="text" name="doctorName" value="{doctor.doctorName}" readonly="readonly"><br><br>
Enter doctorId<input type="text" name="doctorId" value="{doctor.doctorId}" readonly="readonly"><br><br>


Speciality
<select name="speciality" readonly="readonly" value="{doctor.speciality}">
<option value="gynec">Gynec</option>
<option value="ortho">Ortho</option>
<option value="derma">Derma</option>
</select>
<br><br>

Fees<input type="text" name="fees" value="{doctor.fees}"><br><br>
Ratings<input type="text" name="ratings" value="{doctor.ratings}" readonly="readonly"><br><br>
Experience<input type="text" name="experience" value="{doctor.experience}" readonly="readonly"><br><br>


<input type="submit" value="submit">


</form>
</body>
</html>