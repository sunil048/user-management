<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file= "header.jsp" %>
	
	<h1>This is role page</h1>
	<a>Create role</a>
	<form:form modelAttribute="roleForm" method="post" action="${pageContext.request.contextPath}/role/save">
	<table>
		<tr>
			<td><span>Role: </span></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><span>Created Date: </span></td>
			<td><form:input path="createdDate" /></td>
		</tr>
		<tr>
			<td><span>Created By: </span></td>
			<td><form:input path="createdBy" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Add role"></td>
		</tr>
	</table>
	</form:form>
	<Div class="container">
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
			<c:forEach var="role" items="${roleList}">
			<tr>
				<td><c:out value="${role.id}"/></td>
				<td><c:out value="${role.name}"/></td>
			</tr>
				
			</c:forEach>
		</table>
	</Div>

</body>
</html>