<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sp"%>
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
 background-size:200%;
background-repeat: no-repeat;
height: 100%;
font-family: 'Numans', sans-serif;
}
<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

</style>
<script type="text/javascript">
	function dish() {
		var x = document.getElementsByName("dish");
		alert(x.length);
		if (x.checked == false) {
			alert("Dear sir, Please select the dish you want to order");
			return false;
		}
	}
</script>
<body>
	<form name="form1" action="order/submit">

		<table align="center" cellspacing="15">

			<tr>
				<th align="center" colspan="5"><b><u>Starters</u></b></th>
			</tr>
			<tr>
				<td style="display: none;"><input checked type="checkbox"
					name="dish" value="0"></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><b>Name</b></td>
				<td><b>Category</b></td>
				<td><b>Price</b></td>
				<td><b>Description</b></td>
			</tr>
			<sp:forEach var="d" items="${requestScope.dish_List1}">
				<tr>
					<td><input type="checkbox" name="dish" value="${d.dishId}">
					<td>${d.dishName}</td>
					<td>${d.category.categoryName}</td>
					<td>${d.dishPrice}</td>
					<td>${d.dishDescription}</td>
				</tr>
			</sp:forEach>
			<tr>
				<th align="center" colspan="5"><b><u>Main Course</u></b></th>
			</tr>
			<tr>
				<td></td>
				<td>Name</td>
				<td>Category</td>
				<td>Price</td>
				<td>Description</td>
			</tr>
			<sp:forEach var="d" items="${requestScope.dish_List2}">
				<tr>
					<td><input type="checkbox" name="dish" value="${d.dishId}">
					<td>${d.dishName}</td>
					<td>${d.category.categoryName}</td>
					<td>${d.dishPrice}</td>
					<td>${d.dishDescription}</td>
				</tr>
			</sp:forEach>
			<tr>
				<td align="center" colspan="5">
					<h4>
						<b><u>Drinks</u></b>
					</h4>
				</td>
			</tr>

			<tr>
				<td></td>
				<td>Name</td>
				<td>Category</td>
				<td>Price</td>
				<td>Description</td>
			</tr>
			<sp:forEach var="d" items="${requestScope.dish_List3}">
				<tr>
					<td><input type="checkbox" name="dish" value="${d.dishId}">
					<td>${d.dishName}</td>
					<td>${d.category.categoryName}</td>
					<td>${d.dishPrice}</td>
					<td>${d.dishDescription}</td>

				</tr>
			</sp:forEach>
			<tr>
				<td align="center" colspan="5">
					<h4>
						<b><u>Desserts</u></b>
					</h4>
				</td>
			</tr>

			<tr>
				<td></td>
				<td>Name</td>
				<td>Category</td>
				<td>Price</td>
				<td>Description</td>
			</tr>
			<sp:forEach var="d" items="${requestScope.dish_List4}">
				<tr>
					<td><input type="checkbox" name="dish" value="${d.dishId}">
					<td>${d.dishName}</td>
					<td>${d.category.categoryName}</td>
					<td>${d.dishPrice}</td>
					<td>${d.dishDescription}</td>

				</tr>
			</sp:forEach>
			<tr>
				<td align="center" colspan="5">
					<h4>
						<b><u>Roti/Naan</u></b>
					</h4>
				</td>
			</tr>

			<tr>
				<td></td>
				<td>Name</td>
				<td>Category</td>
				<td>Price</td>
				<td>Description</td>
			</tr>
			<sp:forEach var="d" items="${requestScope.dish_List5}">
				<tr>
					<td><input type="checkbox" name="dish" value="${d.dishId}">
					<td>${d.dishName}</td>
					<td>${d.category.categoryName}</td>
					<td>${d.dishPrice}</td>
					<td>${d.dishDescription}</td>

				</tr>
			</sp:forEach>
			<tr>
				<td align="center" colspan="5">
					<h4>
						<b><u>Rice Recepies</u></b>
					</h4>
				</td>
			</tr>

			<tr>
				<td></td>
				<td>Name</td>
				<td>Category</td>
				<td>Price</td>
				<td>Description</td>
			</tr>
			<sp:forEach var="d" items="${requestScope.dish_List6}">
				<tr>
					<td><input type="checkbox" name="dish" value="${d.dishId}">
					<td>${d.dishName}</td>
					<td>${d.category.categoryName}</td>
					<td>${d.dishPrice}</td>
					<td>${d.dishDescription}</td>

				</tr>
			</sp:forEach>
			<tr>
				<td colspan="5"><h4 align="center" style="color: red">${requestScope.Message}</h4></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"></td>
				<td align="right"><input type="submit" name="addToCart"
					value="Add To Cart" formaction="add" onsubmit="dish()"></td>
				<td><input type="submit" name="cart" value="Show Cart"
					formaction="show" onsubmit="dish()"></td>
			</tr>
		</table>

	</form>
</body>
</html>