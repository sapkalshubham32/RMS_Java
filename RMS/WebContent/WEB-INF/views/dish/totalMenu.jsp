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

@import url('https://images.pexels.com/photos/299348/pexels-photo-299348.jpeg?cs=srgb&dl=cuisine-cutlery-delicious-dining-299348.jpg&fm=jpg');

html,body{
background-image: url('https://images.pexels.com/photos/313700/pexels-photo-313700.jpeg?cs=srgb&dl=close-up-of-menu-313700.jpg&fm=jpg');
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
	<table align="center" cellspacing="25">
		<tr >
		<td align="center" colspan="6"><u><b><h2></>Menu Details</h2></b></u></td>
		</tr>
		<tr>
			<td>Name</td>
			<td>Category</td>
			<td>Price</td>
			<td>Description</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<sp:forEach var="d" items="${requestScope.dish_List}">
			<tr>
				<td>${d.dishName}</td>
				<td>${d.category.categoryName}</td>
				<td>${d.dishPrice}</td>
				<td>${d.dishDescription}</td>
				<td ><a href="<spring:url value='/dish/edit?Id=${d.dishId}' />">Edit</a></td>
				<td><a href="<spring:url value='/dish/delete?Id=${d.dishId}'/>">Delete</a></td>
			</tr>
		</sp:forEach>
		<tr>
			<td><a href="<spring:url value='/dish/add' />">ADD NEW DISH</a></td>
		</tr>
	</table>
</body>
</html>