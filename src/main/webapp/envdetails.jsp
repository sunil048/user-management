<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Environment Details</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp"%>
	<h6>Environment Deatils</h6>
	<div>
		<table class="table">
			<tr>
				<th>Sl No</th>
				<th>Id</th>
				<th>Name</th>
				<th>Created Date</th>
				<th>Created By</th>
				<th>Updated Date</th>
				<th>Updated By</th>
			</tr>
			<tr>
				<td>${env.refNo}</td>
				<td>${env.envId}</td>
				<td>${env.name}</td>
				<td>${env.createdDate}</td>
				<td>${env.createdBy}</td>
				<td>${env.upDatedDate}</td>
				<td>${env.updatedBY}</td>
			</tr>
		</table>
		<c:if test="${env.machine != null}">
			<h6>Mchine</h6>
		<table border="1">
			<tr>
				<th>machineName</th>
				<th>machineType</th>
				<th>machineIPAddress</th>
				<th>machineMACAddress</th>
				<th>ramSize</th>
				<th>vmVendor</th>
			</tr>
			<tr>
				<td>${env.machine.machineName}</td>
				<td>${env.machine.machineType}</td>
				<td>${env.machine.machineIPAddress}</td>
				<td>${env.machine.machineMACAddress}</td>
				<td>${env.machine.ramSize}</td>
				<td>${env.machine.vmVendor}</td>
			</tr>
		</table>
		</c:if>
		<c:if test="${env.os != null}">
		<h6>Operating System</h6>
		<table border="1">
			<tr>
				<th>osName</th>
				<th>osType</th>
				<th>osVersion</th>
				<th>vendor</th>
			</tr>
			<tr>
				<td>${env.os.osName}</td>
				<td>${env.os.osType}</td>
				<td>${env.os.osVersion}</td>
				<td>${env.os.vendor}</td>
			</tr>
		</table>
		</c:if>
			<c:if test="${applications != null}">
		<h6>Installed Applications</h6>
		<table border="1">
			<tr>
				<th>App Name</th>
				<th>App Type</th>
				<th>Url</th>
				<th>Instance</th>
			</tr>
			<c:forEach items="${applications}" var="app">
				<tr>
					<td>${app.appName}</td>
					<td>${app.appType}</td>
					<td>${app.url}</td>
					<td>${app.instanceName}</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</div>
</body>
</html>