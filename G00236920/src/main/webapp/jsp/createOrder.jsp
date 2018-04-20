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
		<form:form modelAttribute = "order">
			<table>
				<tr>
					<td>Ship Name:</td>
					<td><form:input path="ship.name"></form:input></td>
				</tr>
				<tr>
					<td>Shipping Company:</td>
					<td><form:input path="shippingCompany.name"></form:input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Order Ship"/></td>
				</tr>
				<tr>
					<td><a href="/index.html">Home</a></td>
				</tr>
			</table>
		</form:form>
	</body>
</html>