<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>User Details</title>
 <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 class="h4">User Details</h1>
	<h1 class="h6">User Form</h1>
	<form:form action="${contextPath}/saveUser" modelAttribute="userDetailsForm" method="post"
		class="form-signin">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input type="text" class="form-control" path="id" />
					<form:errors></form:errors>
				</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><form:input type="text" class="form-control" path="username" />
					<form:errors></form:errors></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input type="text" class="form-control" path="password" />
					<form:errors></form:errors></td>
			</tr>
			<tr>		
				<td>DOB</td>
				<td><form:input path="dob" class="form-control" />
					<form:errors></form:errors></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><%-- <form:input path="gender" class="form-control"  /> --%>
					<form:radiobutton path="gender" value="Male"/>Male 
					<form:radiobutton path="gender" value="Female" />Female 
					<form:errors></form:errors>
			</td>
			</tr>
			<tr>		
				<td> <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>
	<div>
	<h6 class="h6">User list</h6>
	<c:if test="${userList != null}">
	<table class="table">
		<tr>
			<th>ID</th>
			<th>User Name</th>
			<th>Gender</th>
			<th>DOB</th>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>
		   <td><a href="${contextPath}/userHome/"${user.id}>${user.id}</a></td>
		   <td>${user.username}</td>
		   <td>${user.gender}</td>
		   <td>${user.dob}</td>
		<!--    <td> <button type="button" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-pencil"></span> Pencil 
        </button></td> -->
		</tr>
		
		</c:forEach>
	</table>
	
	</c:if>
	</div>

</body>
</html>