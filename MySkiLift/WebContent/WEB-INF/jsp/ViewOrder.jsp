<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.osu.cse5234.controller.PaymentInfo"%>
<%@ page import="edu.osu.cse5234.controller.ShippingInfo"%>
<%@ page import="edu.osu.cse5234.controller.Purchase"%>
<%@ page import="edu.osu.cse5234.controller.Order"%>
<%@ page import="edu.osu.cse5234.controller.Item"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<jsp:include page="header.jsp" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Order</title>
</head>
<body>

	<%
		PaymentInfo paymentInfo = (PaymentInfo) request.getSession().getAttribute("paymentInfo");

		response.getWriter()
				.println("<br/><h2>Your Payment Information: </h2>" + "<br/><b>Credit Card Number: </b>"
						+ paymentInfo.getCcnum() + "<br/><b>Expiration Date: </b>" + paymentInfo.getExpdate()
						+ "<br/><b>CVV Code: </b>" + paymentInfo.getCvvCode() + "<br/><b>Card Holder Name: </b>"
						+ paymentInfo.getCholdername());

		ShippingInfo shippingInfo = (ShippingInfo) request.getSession().getAttribute("shippingInfo");

		response.getWriter()
				.println("<br/><h2>Your Shipping Information: </h2>" + "<br/><b>Name: </b>" + shippingInfo.getName()
						+ "<br/><b>Address1: </b>" + shippingInfo.getAddressLine1() + "<br/><b>Address2: </b>"
						+ shippingInfo.getAddressLine2() + "<br/><b>City: </b>" + shippingInfo.getCity()
						+ "<br/><b>State: </b>" + shippingInfo.getState() + "<br/><b>Zip: </b>"
						+ shippingInfo.getZip());

		response.getWriter().println("<br/><h2>Please Confirm Your Order:</h2><br/><br/>");
		Order order = (Order) request.getSession().getAttribute("order");
		List<Item> items = order.getItems();
		int totalAmount = 0;
		 for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getQuantity() != null) { //looking at anything with quantity > 0 and not null 				
				//System.out.println(items.get(i).getPrice());
				//totalAmount += 24 * 3;
				// ** something is wrong here ** 
				//totalAmount += Integer.parseInt(items.get(i).getPrice()) * Integer.parseInt(items.get(i).getQuantity());
			}
			response.getWriter().println("Item Name: " + items.get(i).getName() + ", Price per Item: "
				+ items.get(i).getPrice() + ", Quantity: " + items.get(i).getQuantity() + "<br />");
		}
					
	%>
<form:form modelAttribute="order" method="post" action="confirmOrder">
<tr>
<td colspan="2"><input type="submit" value="Confirm"></td>
</tr>
</form:form>
<jsp:include page="footer.jsp" />
</body>
</html>