<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<title>User Registry</title>
	</head>
	<body>
		<h1>
			User Registry!
		</h1>

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<button type="button" onclick="location = '${contextPath}${addUserUrl}'">Add User</button>
		</sec:authorize>
		<form:form method="GET" action="${contextPath}${userRegisterUrl}" modelAttribute="UserSearch">
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username"><td>
					<td>Status</td>
					<td><input type="text" name="status"><td>
				</tr>
			</table>
			<input type=submit id="btn1" name="Search" value="Search"/>
		</form:form>
		
		<table border="1">
			<thead>
				<tr>
					<td>Username</td>
					<td>Status</td>
					<td>Authority</td>
				</tr>
			</thead>
			<c:if test="${not empty webstoreUsers}">
		    	<tbody>	    	
			        <c:forEach var="usr" items="${webstoreUsers}">		        	
			            <c:forEach var="auth" items="${usr.authorities}">
							<tr>
								<td>${usr.username}</td>
			                	<td>${usr.status}</td>
								<td>${auth.authority}</td>
							</tr>
						</c:forEach>
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