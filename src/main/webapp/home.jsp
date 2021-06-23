<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.model.Employee" %>
<%@ page import="com.nagarro.model.HRManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home-page</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<style>
input[type=submit] {
	padding: 10px 10px;
	color: white;
	border: none;
	border-radius: 2px;
	cursor: pointer;
}
input[type=submit]:hover {
	color: grey;
}

.t1 td{
	text-align: center;
	padding: 25px;
}
th {
	text-align: center;
	width: 100px;
}
footer{
	margin-bottom: -25px;
   text-align: center;
   font-family: aerial;
   font-size: 15px;
}
</style>
<body>
<c:if test="${username != null}">
<header>
<div style="margin-left: 400px; padding: 20px;">
<h1 style="font-family: aerial; color: black;letter-spacing: 3px;text-decoration: underline;text-shadow: 2px 1px grey;"><b style="color:#f0ad4e;">HR </b>MANAGEMENT PORTAL</h1>
</div>
<div style="margin: -70px 0px -17px 50px;">
<img src="https://upload.wikimedia.org/wikipedia/en/1/17/Nagarro_Logo.png" width="200px" height="65px"/>
</div>
</header>
<hr>
<nav class="navbar bg-dark navbar-expand-lg navbar-light">
    <ul class="navbar-nav mr-auto">
     <li class="nav-item">
	 <div style="color: white; padding: 10px 10px; font-size: 16px;">&nbsp; &nbsp; Employee Listings &nbsp;</div>
	</li>
  			<li class="nav-item">
  					<div align="center">
					<a href="upload.jsp?username=${username}" > 
					<input type="submit" value="Upload Employee Details" class="btn" style=""/>
					</a>
				</div>
			</li>
			<li class="nav-item">
				<div>
					<form action="download" >
						<input type="hidden" name="username" value="${username}"> 
						<input type="submit"  class="btn" value="Download Employee Details" style=""/>
					</form>
				</div>
			</li>	
			<li class="nav-item">
				<div style="margin-left: 420px; margin-top: 10px;color: #f0ad4e;">	
         			<span class="fas fa-user" ></span>
         			<b style="color:#f0ad4e;"><c:out value = "${username}"/></b> 
				</div>
			</li>	
			<li class="nav-item">
			<form action="signout">
				<div  style="margin-left: 25px;color: white;">
				<span class="fas fa-sign-out-alt"></span>
				<input type = "submit" class="btn" value = "Signout" style="margin-left: -10px; margin-bottom: 5px;"/>
				</div>
			</form>
		</li>
		</ul>
		</nav>
		<br>
		<div style="margin: -10px 10px 30px 10px;">
		<table class="t1 table table-striped">
		<thead class="thead-light">
  				<tr>
  				
  					<th>Employee Code</th>
  					<th>Employee Name</th>
  					<th>Location</th>
  					<th>Email</th>
  					<th>Date Of Birth</th>
  					<th>Action</th>
  				</tr>
  				</thead>
  				<c:forEach items = "${employees}" var = "employee">
				<tr>
					<td style="display: none;">${employee.getId()}</td>
  					<td>${employee.getEmpCode()}</td>
  					<td>${employee.getEmpName()}</td>
  					<td>${employee.getEmpLoc()}</td>
  					<td>${employee.getEmpMail()}</td>
  					<td>${employee.getEmpDOB()}</td>
					<td>
						<form action = "edit-employee" method = "get">
							<input type = "hidden" name = "id" value = "${employee.getId()}">
							<input type = "hidden" name = "username" value = "${username}">
							<button type="submit" class="btn" style="margin: -8px;">
							<span class="fas fa-edit" style="color: black;"></span>
							</button>
						</form>
					</td>
				</tr>	
  			</c:forEach>
  			</table>
  			</div>
		<br>
        <footer>Copyright © 2021. All rights reserved.</footer>
		</c:if>
		<c:if test="${username == null}">
			<c:redirect url = "index.jsp"/>
		</c:if>
</body>
</html>