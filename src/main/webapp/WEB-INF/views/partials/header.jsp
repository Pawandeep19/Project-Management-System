<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- bootstrap js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<!-- bootstrap css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<!-- My Css -->
<style> <%@include file="../public/stylesheets/header.css"%> </style>

<!-- icon pack -->
<script src="https://kit.fontawesome.com/3a3d1a0f04.js" crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">


<meta charset="ISO-8859-1">
<title>Project Management System</title>
</head>
<body>

    <!-- Side Navbar -->
	
	<div class="wrapper">
		<div class="sidebar">
			<h2>DASHBOARD</h2>
			<ul>
				<li id="user"><i class="fa fa-user-circle-o"></i> HI,
					${loggedinuser}</li>
				<li><a href="/projectmgmt/home"><i class="fas fa-home"></i>
						DASHBOARD</a></li>
				<li><a href="/projectmgmt/addproject"><i
						class="fa fa-plus-square"></i> CREATE PROJECT</a></li>
				<li><a href="/projectmgmt/changepwd"><i class='fa fa-lock'>
					</i> CHANGE PASSWORD</a></li>
				<li><a href="/projectmgmt/logout"><i class="fa fa-sign-out"></i>LOGOUT</a></li>
			</ul>
		</div>
	</div>
	
	
</body>
</html>