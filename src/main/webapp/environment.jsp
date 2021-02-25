<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Environment</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp"%>
	<form:form modelAttribute="environment"   method="post"
		action="${pageContext.request.contextPath}/environment/save" enctype="multipart/form-data">
		<table>
			<tr>
				<td><span>SL NO: </span></td>
				<td><form:input path="refNo" readonly="true" /></td>
			</tr>
			<%-- <tr>
				<td><span>ID: </span></td>
				<td><form:input path="envId" /></td>
			</tr> --%>
			<tr>
				<td><span>Name : </span></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><span>machineName : </span></td>
				<td><form:input path="machine.machineName"  /></td>
			</tr>
			<tr>
				<td><span>machineType: </span></td>
				<td><form:input path="machine.machineType" /></td>
			</tr>
			<tr>
				<td><span>machineIPAddress: </span></td>
				<td><form:input path="machine.machineIPAddress"  value="${machine.machineIPAddress}"/></td>
			</tr>
			<tr>
				<td><span>machineMACAddress: </span></td>
				<td><form:input path="machine.machineMACAddress" value="${machine.machineMACAddress}"/></td>
			</tr>
			<tr>
				<td><span>ramSize: </span></td>
				<td><form:input path="machine.ramSize"  value="${machine.ramSize}"/></td>
			</tr>
			<tr>
				<td><span>vmVendor: </span></td>
				<td><form:input path="machine.vmVendor" value="${machine.vmVendor}" /></td>
			</tr>
			<tr>
				<td><span>Os Type: </span></td>
				<td><form:input path="os.osType"/></td>
			</tr>
			<tr>
				<td><span>osName: </span></td>
				<td><form:input path="os.osName"/></td>
			</tr>
			<tr>
				<td><span>osVersion: </span></td>
				<td><form:input path="os.osVersion"/></td>
			</tr>
			<tr>
				<td><span>vendor: </span></td>
				<td><form:input path="os.vendor"/></td>
			</tr>
			
			
				<td></td>
				<td><input type="submit" value="Add Environment"></td>
			</tr>
		</table>
	</form:form>
	<h6>Environments</h6>
	<c:if test="${environments != null}">
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
			<c:forEach items="${environments}" var="env">
				<tr>
					<td><a href="${contextPath}/environment/details/${env.refNo}">${env.refNo}</a></td>
					<td>${env.envId}</td>
					<td>${env.name}</td>
					<td>${env.createdDate}</td>
					<td>${env.createdBy}</td>
					<td>${env.upDatedDate}</td>
					<td>${env.updatedBY}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>