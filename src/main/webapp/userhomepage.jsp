<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<%@include file= "header.jsp" %>
	<h4 class="h4">User Details</h4>
    <table>
    <tr>
    	  <td > <span class="badge">User Id</span> </td>
    	  <td >${user.id}</td>
    	  <input type="hidden" id="userId" value="${user.id}"/>
    	</tr>
    	<tr>
    	  <td>User Name </td>
    	  <td>${user.username}</td>
    	</tr>
    	<tr>
    	  <td>Gender</td>
    	  <td>${user.gender}</td>
    	</tr>
    	<tr>
    	  <td>DOB </td>
    	  <td>${user.dob}</td>
    	</tr>
    	<tr>
    	  <td>User is Active? </td>
    	  <td>${user.isActive}</td>
    	</tr>
    	<tr>
    	  <td>Created Date : </td>
    	  <td>${user.createdDate}</td>
    	</tr>
    
    </table>
    Roles
    <c:forEach items="${user.roles}" var="role">
    <c:out value="${role.name}"></c:out>
    
    </c:forEach>
    <br>
	<h4 class="h4">Select user Roles</h4>
	<div class="container">
		<table>
			<tr>
				<td>
					<div> 
						<select class="custom-select" multiple id="available_roles" >
							<option selected>Open this select menu</option>
							<!-- <option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option> -->
						</select>
					</div>
				</td>
				<td>
					<button type="button"  onclick="moveRoles('available_roles','selected_roles')" class="btn btn-default btn-sm">
					<span class="glyphicon glyphicon-menu-right"></span></button> 
						<br>
						<button onclick="moveRoles('selected_roles','available_roles')" class="btn btn-default btn-sm"><span
							class="glyphicon glyphicon-menu-right"></span></button> 	
				</td>
				<td>
				<select class="custom-select" multiple id="selected_roles" >
							
				</select>
				
				</td>
			</tr>
			<tr>
			<td colspan="2">
				<button type="button" class="btn btn-default" onclick="submitRoles()">Submit</button>
			</td>
			</tr>
		</table>
		

	</div>
<script type="text/javascript">
 function moveRoles(available_roles,selected_roles){
	 
	  var availableRolesSelect=document.getElementById(available_roles);
      for (var i = 0; i < availableRolesSelect.options.length; i++) {
         if(availableRolesSelect.options[i].selected ==true){
							//alert(availableRolesSelect.options[i].value);
							
              var selectedOption = availableRolesSelect[i];
              var optionElement = document.createElement("OPTION");
				 optionElement.setAttribute("value",selectedOption.value);
				 optionElement.setAttribute("rolename",selectedOption.getAttribute("rolename"));
				 
				 console.log(selectedOption)
				 //var name = selectedOption.()
				 console.log(selectedOption.rolename)
				 var t = document.createTextNode(selectedOption.getAttribute("rolename"));
				 optionElement.appendChild(t);
				 document.getElementById(selected_roles).appendChild(optionElement)
				 document.getElementById(available_roles).removeChild(availableRolesSelect.options[i])
          }
      }
 }

 function setValues(data){
	 console.log('data'+data)

	 var rolesJsonData = JSON.parse(data);
	// Element optionElement = document.createDocument();
	console.log(rolesJsonData)
	 for (var i=0; i<rolesJsonData.length; i++) {
				var counter = rolesJsonData[i];
				var optionElement = document.createElement("OPTION");
				 optionElement.setAttribute("value",counter.id);
				 optionElement.setAttribute("rolename",counter.name);
				 var t = document.createTextNode(counter.name);
				 optionElement.appendChild(t);
				 document.getElementById("available_roles").appendChild(optionElement)
		    }
 }
 function loadRoles(){
	 
	 var xmlhttp = new XMLHttpRequest();

	    xmlhttp.onreadystatechange = function() {
	        if (xmlhttp.readyState == XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
	           if (xmlhttp.status == 200) {
	              // document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
	               console.log(xmlhttp.responseText)
	               setValues(xmlhttp.responseText);
	           }
	           else if (xmlhttp.status == 400) {
	              alert('There was an error 400');
	           }
	           else {
	               alert('something else other than 200 was returned');
	           }
	        }
	    };

	    xmlhttp.open("GET", "http://localhost:8082/role/list", true);
	    xmlhttp.send();
 }
 function updateUserDetailsTobackEnd(userId,roleList){
	var xmlhttp = new XMLHttpRequest();

xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
			 if (xmlhttp.status == 200) {
					// document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
					 console.log(xmlhttp.responseText)
					 //setValues(xmlhttp.responseText);
					 alert(xmlhttp.responseText)
			 }
			 else if (xmlhttp.status == 400) {
					alert('There was an error 400');
			 }
			 else {
					 alert('something else other than 200 was returned'+xmlhttp);
					 console.log(xmlhttp)
			 }
		}
};

xmlhttp.open("GET", "http://localhost:8082/role/update?UserId="+userId+"&roleList="+roleList, true);
xmlhttp.send();
 }

 function submitRoles(){
	 var userId = document.getElementById("userId").value;
	 alert(userId)
	 var selected_roles = document.getElementById('selected_roles');
	 console.log(selected_roles)
	 var myList;
	 for (var i =0;i < selected_roles.options.length;i++){
		 if (selected_roles.options[i].selected == true){
			 console.log('adding to list'+selected_roles.options[i])
			 if (myList == undefined)
					 myList = selected_roles.options[i].value;
				else
				   myList =myList+'-'+selected_roles.options[i].value;
			 console.log(myList)
		 }
	 }
	 if (myList.length > 0)
	 		updateUserDetailsTobackEnd(userId,myList);
 }
</script>
</body>
<script type="text/javascript">
	window.onload=loadRoles();
</script>
</html>