<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipping Entry Form</title>
</head>
<body>
	<h1>Shipping Entry Form</h1>
	<form:form modelAttribute="shippingInfo" method="post" action="submitShipping">
		<table>
			<tr>
				<th>Name</th>
				<th>Address1</th>
				<th>Address2</th>
				<th>City</th>
				<th>State</th>
				<th>Zip</th>
			</tr>
			<tr>
				<td><form:input path="name" /></td>
				<td><form:input path="addressLine1" /></td>
				<td><form:input path="addressLine2" /></td>
				<td><form:input path="city" /></td>
				<td><form:input path="state" /></td>
				<td><form:input path="zip" /></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="Shipping Submit"></td>
	  		</tr>
			</table>
			</form:form>
			<jsp:include page="footer.jsp" />
</body>