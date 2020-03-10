<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sp"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* Made with love by Mutiullah Samim*/

@import url('https://fonts.googleapis.com/css?family=Numans');

html,body{
background-image: url('https://images.pexels.com/photos/299348/pexels-photo-299348.jpeg?cs=srgb&dl=cuisine-cutlery-delicious-dining-299348.jpg&fm=jpg');
 background-size:250%;
background-repeat: no-repeat;
height: 80%;
font-family: 'Numans', sans-serif;
}
<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</style>
</head>
<body>
	<form method="post" action="/RMS/paytm" align="center">
		<h1>
			Mrignayani Restaurant,<br />Pune.
		</h1>
		<hr width="450" size="5" />
		<table align="center" cellspacing="10">
			<tr class="information">
				<td colspan="4">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>

				<td></td>
				<td></td>
				<td align="right"><b>Date: <f:formatDate
							value="<%=new Date()%>" type="date" /></b></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr>
				<td align="left">Customer
					Id:${sessionScope.transaction.customer.customerId}</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td align="right">Invoice
					number:${sessionScope.transaction.transactionId}</td>

			</tr>
			<tr>
				<td align="left">Customer Name:
					${sessionScope.transaction.customer.name}</td>
			</tr>
			<tr>
				<td align="left">Phone Number
					:${sessionScope.transaction.customer.mobileNo}</td>
			</tr>
			<tr>
				<td align="left">Email
					:${sessionScope.transaction.customer.email}<br>
				</td>
			</tr>
			<tr>

			</tr>

		</table>
		<hr size="5" width="450" />
		<table cellspacing="10" align="center">
			<tr>
				<th>Item no</th>
				<th></th>
				<th></th>
				<th>Quantity</th>
				<th></th>
				<th>Price</th>
			</tr>
			<sp:forEach var="d" items="${sessionScope.orderedlist}">
				<tr>
					<td>${d.dishName}</td>
					<td></td>
					<td></td>
					<td>1</td>
					<td></td>
					<td>&#8377;${d.dishPrice}</td>
				</tr>
			</sp:forEach>
		</table>
		<hr size="5" width="450" />
		<table align="center" cellspacing="10">
			<tr class="total">
				<td colspan="30">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td align="right"><b>Total:</b></td>
				<td></td>
				<td align="right"><b>&#8377;${sessionScope.transaction.totalBill }</b></td>
			</tr>
		</table>
		<hr width="450" />
		<table align="center" cellspacing="25">
			<tr>
				<td colspan="2">Do you want bill on your mail id<br />
					(provide EmailId if yes)
				</td>
			<tr>
				<td colspan="2"><input type="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>