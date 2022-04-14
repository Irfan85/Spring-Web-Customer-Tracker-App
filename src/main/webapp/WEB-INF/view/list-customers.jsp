<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer list</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer A Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<input type="button" class="add-button" value="Add Customer" onclick="window.location.href='showFormForAdd';"/>
		
		<!-- HTML table goes here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			
			<!-- Loop over customers and dynamically generate rows for each of them -->
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td> ${customer.firstName} </td>
					<td> ${customer.lastName} </td>
					<td> ${customer.email} </td>
				</tr>
			</c:forEach>
		</table>
		
		</div>
	</div>
</body>
</html>