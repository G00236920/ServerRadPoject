<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>
</head>
<body>
	<h1>Ships</h1>
	<table border=1>
		<tr>
			<th>Name</th>
			<th>Passengers</th>
			<th>Cost</th>
			<th>Length (Metres)</th>
			<th>Shipping Company</th>

		</tr>
		<tr>
			<c:forEach items="${ships}" var="ships">
				<tr>
					<td>${ships.name}</td>
					<td>${ships.passengers}</td>
					<td>${ships.cost}</td>
					<td>${ships.metres}</td>
					<td>${ships.shippingCompany.name}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	 <a href="index.html">HOME</a>
</body>
</html>