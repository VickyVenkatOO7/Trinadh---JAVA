<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div align="center">
		<h1>FirstDemoProject</h1>
		<form action="addStudents">
			<input type="number" placeholder="Id" name="stdId"><br>
			<input type="text" placeholder="Name" name="stdName"><br>
			<input type="text" placeholder="Tech" name="stdTech"><br>
			<input type="submit"><br>
		</form>

		<form action="fetchStudentsById">
			<input type="number" placeholder="Id" name="stdId"><br>
			<input type="submit" value="FetchDetailsById"><br>
		</form>
		
		<form action="fetchallStudents">
			<input type="submit" value="FetchAllDetails">
		</form>
	</div>
</body>
</html>