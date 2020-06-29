<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body class="homepage">
	<nav>
	<ul>
	<li><a href="${pageContext.request.contextPath}/DoctorLoginController">Doctor</a></li>
	<li><a href="${pageContext.request.contextPath}/LoginController">Login</a></li>
	<li><a href="${pageContext.request.contextPath}/SignupController">SignUp</a></li>
	<li><a href="${pageContext.request.contextPath}/HomePageViewController">Home</a></li>
	</ul>
	</nav>
	
	<div class="hp1" style="display: inline-flex; align-items:center; margin-top: 10em; margin-left:2em;">
		<div class="hp2" style="color:white;">
			<h1>WELCOME TO MY SITE</h1>
			<p style="color:black; font-size:2em; font-weight:bold;">THE VERY BEST <br> <span style="color:darkblue;">DOCTORS</span></p>
			<p style="font-size:1.5em;">Search our databases of thousands of professionals <br>by speciality location hospital affliation and insurance<br> to find the right fit for you</p>
		</div>
		<div class="hp3">
			<img alt="" src="./assets/home1.jpg">
		</div>
	</div>
	
	
</body>
</html>