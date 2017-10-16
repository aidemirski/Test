<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<title>Product Registry</title>
	</head>
	<body>
		<h1>
			Product Registry!
		</h1>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button type="button" onclick="location = '${contextPath}${addProductUrl}'">Add Product</button>
		</sec:authorize>
		<form:form method="GET" action="${contextPath}${productRegisterUrl}" modelAttribute="ProductSearch">
			<table>
				<tr>
					<td>Product name</td>
					<td><input type="text" name="productName"><td>
					<td>Status</td>
					<td><input type="text" name="status"><td>
				</tr>
			</table>
			<input type=submit id="btn1" name="Search" value="Search"/>
		</form:form>
		
		<table border="1">
			<thead>
				<tr>
					<td>Product name</td>
					<td>StatusId</td>
					<td>Status</td>
					<td>Product price</td>
					<td>Type</td>
					<td>Quantity</td>
				</tr>
			</thead>
			<c:if test="${not empty products}">
		    	<tbody>
			        <c:forEach var="prod" items="${products}">
			            <tr>
			                <td>${prod.productName}</td>
			                <td>${prod.statusId}</td>
			                
			                <td>${prod.status.statusName}</td>
			                
			                <td>${prod.productPrice}</td>
			                <td>${prod.type}</td>
			                <td>${prod.quantity}</td>
			            </tr>
			        </c:forEach>
		        </tbody>
			</c:if>
		</table>

		<div>Username: ${user.username}</div>
		<c:forEach var="authority" items="${user.authorities}">
			<div>authority: ${authority}</div>
		</c:forEach>
		

		<form action="/webstore/logout" method="post">
			<input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>