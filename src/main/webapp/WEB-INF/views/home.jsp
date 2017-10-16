<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Web Store Home Page!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<button type="button" onClick="location='/webstore/products'">Products</button>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<button type="button" onClick="location='${contextPath}${usersUrl}'">Users</button>
	</sec:authorize>
</body>
</html>
