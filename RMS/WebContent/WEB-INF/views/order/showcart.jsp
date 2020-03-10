<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sp"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
 background-size:100%;
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
	<form method="get">
		<table align="center" cellspacing="25">
			<tr>
				<td colspan="4">${requestScope.msg}</td>
			</tr>
			<tr>
				<td colspan="2">Total Bill :</td>
				<td colspan="2">${requestScope.bill}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td align="center">Price</td>
				<td align="center">Quantity</td>
				<td></td>
			</tr>
			<sp:forEach var="d" items="${requestScope.cartList }">

				<tr>
					<td>${d.dishName }</td>
					<td align="center">${d.dishPrice }</td>
					<td align="center"><select name="qty">
							<option value="1" selected>1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select>
					<td><a
						href="<spring:url value='/order/delete?id=${d.dishId}' /> ">Delete</a></td>
				</tr>
			</sp:forEach>
			<tr>
				<td></td>
				<td></td>
				<!-- 				<td align="center"><input type="submit" name="Place order" -->
				<!-- 					value="Place Order"></td> -->
				<td align="right"><input type="submit" name="addToCart"
					value="Add More Items" formaction="main"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>