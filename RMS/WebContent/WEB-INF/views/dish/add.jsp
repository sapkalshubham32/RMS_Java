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

@import url('https://images.pexels.com/photos/299348/pexels-photo-299348.jpeg?cs=srgb&dl=cuisine-cutlery-delicious-dining-299348.jpg&fm=jpg');

html,body{
background-image: url('https://images.pexels.com/photos/5791/food-healthy-soup-leek.jpg?cs=srgb&dl=leek-and-potato-soup-with-parsley-5791.jpg&fm=jpg');
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
	<table>
		<sp:form action="add_dish" method="get" modelAttribute="dish">
			<tr style="display: none;">

				<td>Dish ID :</td>
				<td><sp:input path="dishId" /></td>
			</tr>
			<tr>

				<td>Dish Name :</td>
				<td><sp:input path="dishName" required="required"/></td>
			</tr>
			<tr>
				<td>Dish Description :</td>
				<td><sp:input path="dishDescription" required="required"/></td>
			</tr>
			<tr>
				<td>Dish Category :</td>
				<td><sp:select path="category.categoryId" required="required">
						<c:forEach var="c" items="${requestScope.category_list}">
							<sp:option value="${c.categoryId}">${c.categoryName}</sp:option>
						</c:forEach>
					</sp:select></td>
			</tr>
			<tr>
				<td>Dish Price :</td>
				<td><sp:input type="number" path="dishPrice" required="required"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="Submit" value="Add Dish"></td>
			</tr>
		</sp:form>
	</table>
</body>
</html>