<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<title>Add A Product</title>
	</head>
	<body>
		<h1>
			Add A Product!
		</h1>

		<form:form method="POST" action="${contextPath}${addProductUrl}" modelAttribute="product">
			
			Product name<input type="text" name="productName"><br>
			Product price<input type="text" name="productPrice"><br>
			Type<input type="text" name="type"><br>
			Quantity<input type="text" name="quantity"><br>
				
			<input type=submit id="btn1" name="submit" value="Add"/>
		</form:form>

		<form action="/webstore/logout" method="post">
			<input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</body>
</html>