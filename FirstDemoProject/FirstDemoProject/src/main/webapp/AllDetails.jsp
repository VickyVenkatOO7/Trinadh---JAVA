<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Student Details</title>
</head>
<body>
	<h1>All Student Details</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Technology</th>
			</tr>
		</thead>
		<tbody>
			<!-- Iterate over the students and display each student in a row -->
			<c:forEach var="student" items="${students}">
				<tr>
					<td>${student.stdId}</td>
					<td>${student.stdName}</td>
					<td>${student.stdTech}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/">Back to Home</a>
</body>
</html>
