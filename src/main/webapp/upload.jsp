<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Upload Employee</title>
<style>

.container {
	border-radius: 5px;
	background-color: #F5F8FB;
	padding: 20px;
}
h3{
	 color: white;
	 font-family: aerial;
}
body{
	margin: 30px;
	background-color: gray;
}
header{
	width: 100%;
	margin: 30px;
}
</style>
</head>
<body>
	<c:if test="${param.username != null}">
	<header>
		<div>
			<h3>Welcome <b><c:out value = "${param.username}"/>!</b> You can add new employees here.</h3>
		</div>
	</header>
	<br>
		<div class = "container">
		<br>
		<br>
			<form  action = "upload" method = "post">
  				<table align = "center">
  					<tr>
						<td>
							Employee Code: 
						</td>
						<td>
						<div class="col-lg-12">
							<input type = "text" class="form-control" name = "empCode" required />
						</div>
						</td>
					</tr>
					<tr>
						<td>
							Employee Name: 
						</td>
						<td>
						<div class="col-lg-12">
							<input type = "text" class="form-control" name = "empName" required/>
						</div>
						</td>
					</tr>
					<tr>
						<td>
							Location: 
						</td>
						<td>
						<div class="col-lg-12">
							<input type = "text" class="form-control" name = "empLoc" required/>
						</div>
						</td>
					</tr> 
					<tr>
						<td>
							E-Mail: 
						</td>
						<td>
						<div class="col-lg-12">
							<input type = "text" class="form-control"  name = "empMail" required />
						</div>
						</td>
					</tr> 
					
					<tr>
						<td>
							Date of birth: 
						</td>
						<td>
						<div class="col-lg-12">
							<input type = "date" class="form-control" name = "empDOB" required/> 
						</div>
						</td>
					</tr>
					<tr>
						<td>	
						</td>
						<td align = "left">
						<br>
						<div class="col-sm-8">
							<input type = "submit" class="btn btn-secondary" value = "upload"/> 
						</div>
						</td>
					</tr>
	  			</table>
					<input type = "hidden" name = "username" value = "${param.username}" />  				
  			</form>
  			<br>
		<br>
	</div>
	</c:if>
	<c:if test="${param.username == null}">
			<c:redirect url = "home.jsp"/>
	</c:if>
</body>
</html>