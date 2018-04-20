<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Show Ships</title>
	</head>
	<body>
	
	<h1>List of Ships</h1>
		<table>
		  <tr>
		   <th>Name</th>
		   <th>Passengers</th>
		   <th>Cost</th>
		   <th>Length(Metres)</th>
		   <th>Shipping Company</th>
		  </tr>
		  <tr>
		    <c:forEach items=`${ships}` var="ship">
		      <tr> 
		        <td>${ship.name}</td>
		        <td>${ship.passengers}</td>
		        <td>${ship.cost}</td>
		        <td>${ship.metres}</td>
		        <td>${ship.metres}</td>
		      </tr>
		    </c:forEach>
		  </tr>
		</table>
	
	
		<a href="/index.html">Home</a>
	
	</body>
</html>