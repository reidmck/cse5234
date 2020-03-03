<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="header.jsp" />

<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">
    <table>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<input type="hidden" name="item.name" value="${item.name}" />
			<td><c:out value="${item.name}"></c:out></td>
			<td><c:out value="${item.price}"></c:out></td>
			<input type="hidden" name="items.get(${loop.index}).price" value="${item.price}" />
			<td><form:input path="items[${loop.index}].quantity" /></td>
		</tr>
	</c:forEach>

	  <tr>
		<td colspan="2"><input type="submit" value="Purchase"></td>
	  </tr>
    </table>
</form:form>
<jsp:include page="footer.jsp" />
</body>
</html>