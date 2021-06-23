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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>edit</title>
<style>
.container {
	border-radius: 5px;
	background-color: #F5F8FB;
	padding: 20px;
}
</style>
</head>
<body style="margin: 30px; background-color: gray;">
<c:if test="${param.username != null}">
	<header style="width: 100%; margin: 30px;">
		<div>
			<h3 style="font-family: aerial; color: white;">Welcome <b><c:out value = "${param.username}"/>!</b> You can edit employee here.</h3>
		</div>
	</header>
	<br>
	<div class = "container">
		<br>
		<br>
			<form action = "update" method = "post">
			<table align = "center">
			<tr style="display: none;">
					<td>id</td>
					<td>
					<div class="col-lg-12">
						<input type = "text" class="form-control" name = "id" value = "${employee.getId()}" readonly/>
					</div>
					</td>
				</tr>
				<tr>
					<td>Employee Code: </td>
					<td>
					<div class="col-lg-12">
						<input type = "text" class="form-control" name = "empCode" required value = "${employee.getEmpCode()}" readonly />
					</div>
					</td>
				</tr>
				<tr>
					<td>Employee Name: </td>
					<td>
					<div class="col-lg-12">
						<input type = "text" class="form-control" name = "empName" required value = "${employee.getEmpName()}"/>
					</div>
					</td>
				</tr>
				<tr>
					<td>Location: </td>
					<td>
					<div class="col-lg-12">
						<input type = "text" class="form-control" name = "empLoc" required value = "${employee.getEmpLoc()}"/>
					</div>
					</td>
				</tr>
				<tr>
					<td>E-Mail: </td>
					<td>
					<div class="col-lg-12">
						<input type = "text" class="form-control" name = "empMail" required value = "${employee.getEmpMail()}"/>
					</div>
					</td>
				</tr>
				<tr>
					<td>Date of birth:  </td>
					<td>
					<div class="col-lg-12">
						<input type = "date" class="form-control" name = "empDOB" required value = "${employee.getEmpDOB()}"/>
					</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td align = "left">
						&nbsp;
						<div class="col-sm-8">
						 <input  type = "submit" class="btn btn-secondary" value = "Update" />
						</div>
					</td>
				</tr>
			</table>
				<input type = "hidden" name = "username" value = "${username}" />  
			</form>
			</div>
		<br>
</c:if>
		<c:if test="${username  == null}">
			<c:redirect url = "index.jsp"/>
		</c:if>

</body>
</html>