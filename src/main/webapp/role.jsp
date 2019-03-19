<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is role page</h1>
	<a>Create role</a> 
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