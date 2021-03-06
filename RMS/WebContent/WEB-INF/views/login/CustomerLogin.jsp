<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp"%>
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
<sp:form method="post" modelAttribute="transaction">
<table align="center">
			<tr>
				<td colspan="2"><h1>Welcome to Mrignayani Restaurant</h1></td>
			</tr>
			<tr>
				<td colspan="2" align="center">(Enter the following details)</td>
			</tr>
			<tr>
				<td align="center">Registration Id:</td>
				<td><sp:input align="center" path="transactionId" required="required"/></td>
			</tr>
			<tr>
				<td align="center">OTP :</td>
				<td><sp:input align="center" path="OTP" required="required"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login" style="height: 20px; width: 180px" /></td>
			</tr>
			<tr>
				<td colspan="2"><p>
					<p></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<p style="color: red">${param.message}</p>
				</td>
			</tr>
		</table>
	</sp:form>
</body>
</html>