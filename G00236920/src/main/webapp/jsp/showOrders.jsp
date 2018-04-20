<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Show Orders</title>
	
	</head>
	<body>
	
		<h1>List of Orders</h1>
			<table>
			  <tr>
			   <th>Order Number</th>
			   <th>Shipping Company Name</th>
			   <th>Ship Name</th>
			   <th>Order Date</th>
			  </tr>
			  <tr>
			    <o:forEach items="${orders}" var="order">
			      <tr> 
			        <td>${order.oid}</td>
			        <td>${order.scid}</td>
			        <td>${order.sid}</td>
			        <td>${order.date}</td>
			      </tr>
			    </o:forEach>
			  </tr>
			</table>
			
		<a href="/index.html">Home</a>
	
	</body>
</html>