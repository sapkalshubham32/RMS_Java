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
</head>
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
<body>
	<sp:form method = "POST" modelAttribute="customer" >	
		<table align="center">
			<tr>
				<td><h1>REGISTRATION FORM</h1></td>
				
			</tr>
			<tr>
				<td>Name :</td>
				<td><sp:input path="name" required="required"/></td>
			</tr>
			<tr>
				<td>Mobile No :</td>
				<td><sp:input type="number" path="mobileNo" required="required" maxlength="10" min = "10"/></td>
			</tr>
			<tr>
				<td>Email Id :</td>
				<td><sp:input type="email" path="email" required="required" /></td>
			</tr>
			<tr>
				<td>No of Members :</td>
				<td><input type="number" name ="noOfMember" required="required" min = "1"/></td>
			</tr>
			<tr>
				<td><input type="submit" name = "submit" required="required" value = "Register Me" /></td>
				<td></td>
			</tr>
			
		</table>
	</sp:form>
</body>
</html>