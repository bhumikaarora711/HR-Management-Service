<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"><style>

.loginbody{
	margin: 100px 100px 100px 100px; 
	padding: 1px;
  	font-family: "Karla";
  	font-size: 17px;
  	background-color: #d0d0ce;
  	box-shadow: 10 15px 20px 5 rgba(172, 168, 168, 0.43);
}
.container{
	background-color: white;
	padding: 20px;
 
}
 .login-card-footer-nav a {
    font-size: 14px;
    color: #919aa3;
    }
    
.card {
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
  transition: 0.3s;
  border-radius: 5px; /* 5px rounded corners */
}
h3{
	color: black;
	margin: 50px 20px 0px 75px;
	padding: 10px 0px 5px 0px;
	font-family: "sans-serif";
}
.loginput{
	width: 300px;
	float: left;
	margin-left: 65px;
	padding: 13px 20px 12px;
    background-color: #000;
    border-radius: 4px;
    font-size: 17px;
    font-weight: bold;
    line-height: 15px;
    color: #fff;
}
.form-group{
	 margin-left: 50px;
}
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}
button[type=submit]:hover {
  color: #d0d0ce;
}
footer{
	margin-bottom: -25px;
   text-align: center;
   font-family: aerial;
   font-size: 13px;
}
</style>
</head>
 <body class="loginbody">
 <div class="card">
<div class="container">
<div class="side1" style="margin: 0px 10px 0px -10px;">
<h3>Sign into your account</h3>
<br>
<form id="login" action="signin" method="post">
 <div class="form-group">
  <div class="col-sm-4">
  <input type="text" class="form-control" id="username" name="username" required placeholder="Enter Username">
 </div>
   </div>
  <div class="form-group">
  <div class="col-sm-4">
    <input type="password" class="form-control" id="password" name="password" required placeholder="Enter Password">
   </div>
  </div>
 <button type="submit" class="btn btn-block login-btn mb-4 loginput" value="Login>>">Login</button><br>
 <br>
 <br>
<nav class="login-card-footer-nav" style="float: left; margin-left: 130px;">
                  <a href="#!">Terms of use.</a>
                  <a href="#!">Privacy policy</a>
                  <br>
                  <br>
</nav>
</form>
</div>
<div style="margin: -200px 10px 10px 390px; width: 100px;">
<img src="https://upload.wikimedia.org/wikipedia/en/1/17/Nagarro_Logo.png"/>
</div>
</div>
</div>
<footer>Copyright © 2021. All rights reserved.</footer>
 <%
  if(request.getParameter("msg")!=null)
  { 
  %>
  <div class="row d-flex justify-content-center fixed-top">
      <div class="col-lg-6 ">
          <div class="alert alert-warning alert-dismissible fade show d-flex justify-content-center" id="alert">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              	Sorry!!! No User Found.
          </div>
      </div>       
</div>  
<%
  }
%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>  
</html>
    