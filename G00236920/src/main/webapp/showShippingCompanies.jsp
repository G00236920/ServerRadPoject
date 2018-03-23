<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Show Shipping Companies</title>
		
	</head>
	<body>
		<h1>List of Shipping Companies</h1>
			<table>
			  <tr>
			   <th>Name</th>
			   <th>Home Port</th>
			   <th>Balance</th>
			   <th>Ships</th>
			  </tr>
			  <tr>
			    <c:forEach items="${companies}" var="company">
			      <tr> 
			        <td>${company.name}</td>
			        <td>${company.homePort}</td>
			        <td>${company.balance}</td>
			        <td>${company.balance}</td>
			      </tr>
			    </c:forEach>
			  </tr>
			</table>
		<a href="/index.html">Home</a>
	
	</body>
</html>