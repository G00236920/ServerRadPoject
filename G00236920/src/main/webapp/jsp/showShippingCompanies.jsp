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
	<h1>List of Shipping Companies</h1>
	<table border=1>
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>Ships</th>
		</tr>
		<tr>
			<c:forEach items="${companies}" var="companies">
				<tr>
					<td>${companies.name}</td>
					<td>${companies.homePort}</td>
					<td>${companies.balance}</td>
					<td>
						<c:forEach items="${companies.ships}" var="ship">
							<li>${ship.name}, ${ship.metres} Mtrs, ${ship.cost}</li>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
 <a href="index.html">Home</a>
</body>
</html
>