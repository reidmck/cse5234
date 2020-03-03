<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp" />
<title>Payment Entry Form</title>
</head>
<body>
	<h1>Payment Entry Form</h1>
	<form:form modelAttribute="paymentInfo" method="post" action="submitPayment">
		<table>
			<tr>
				<th>Credit Card Number</th>
				<th>Expiration Date</th>
				<th>cvv Code</th>
				<th>Cardholder Name</th>
			</tr>
			<tr>
				<td><form:input path="ccnum" /></td>
				<td><form:input path="expdate" /></td>
				<td><form:input path="cvvCode" /></td>
				<td><form:input path="choldername" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Payment Submit"></td>
	  		</tr>
			</table>
			</form:form>
			<jsp:include page="footer.jsp" />
</body>