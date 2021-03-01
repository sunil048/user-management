<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.repository.dao.EnvironmentDao" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp"%>
	<form:form modelAttribute="application" method="post"
		action="${pageContext.request.contextPath}/application/save">
		<table>
			<tr>
				<td><span>env : </span></td>
				<%-- <td><form:input path="env" /></td> --%>
				<td>
					<form:select path="envRef"> 
					<%-- <form:options items="${envList}" itemValue="env" itemLabel="env"/>   --%>
					<form:option value="" label="--- Select Age ---"/>
					<c:forEach var="env" items="${envList}">
						<form:option  label="${env.value}" value="${env.key}" envName="${env.value}" />
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><span>ID: </span></td>
				<td><form:input path="id" value="${id}" readonly="true"/></td>
			</tr>
			<tr>
				<td><span>appName: </span></td>
				<td><form:input path="appName" /></td>
			</tr>
			<tr>
				<td><span>appType: </span></td>
				<td><form:input path="appType" /></td>
			</tr>
			<tr>
				<td><span>instanceName: </span></td>
				<td><form:input path="instanceName" /></td>
			</tr>
			<tr>
				<td><span>installedPath: </span></td>
				<td><form:input path="installedPath" /></td>
			</tr>
			<tr>
				<td><span>user name : </span></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><span>password: </span></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><span>port: </span></td>
				<td><form:input path="port" /></td>
			</tr>
			<tr>
				<td><span>url: </span></td>
				<td><form:input path="url" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Add Application"></td>
			</tr>
		</table>
	</form:form>
	<h6>Applications</h6>
	<c:if test="${applications != null}">
		<table class="table">
			<tr>
				<tr>
				<td><span>env : </span></td>
				<td><span>appName</span></td>
				<td><span>ID: </span></td>
				<td><span>appType: </span></td>
				<td><span>instanceName: </span></td>
				<td><span>installedPath: </span></td>
				<td><span>username : </span></td>
				<td><span>password: </span></td>
				<td><span>port: </span></td>
				<td><span>url: </span></td>
			</tr>
			<c:forEach items="${applications}" var="app">
				<tr>
					<td><a href="${contextPath}/environment/details/${app.envRef}" > ${app.envRef} ${app.envName}
					<%-- <%
					EnvironmentDao envDao =  new EnvironmentDao();
					
					%>
					<% out.println(envDao.getEnvironmentNameByRefNo(Long.valueOf((String)request.getAttribute("envRef"))));%> --%>
					<%-- <c:out><%envDao.getEnvironmentNameByRefNo(Long.valueOf(request.getAttribute("envRef"))));%></c:out> --%>
					</a></td>
					<td>${app.appName}</td>
					<td>${app.id}</td>
					<td>${app.appType}</td>
					<td>${app.instanceName}</td>
					<td>${app.installedPath}</td>
					<td>${app.username}</td>
					<td>${app.password}</td>
					<td>${app.port}</td>
					<td>${app.url}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>