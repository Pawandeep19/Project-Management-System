<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
   <!-- jQuery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <!-- bootstrap js -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
   
   <!-- loginPage js -->
   <script>
      <%@include file="public/javascripts/login.js"%>
   </script>
   
   <!-- bootstrap css -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- our css -->
   <style> <%@include file="public/stylesheets/login.css"%> </style>

<meta charset="ISO-8859-1">
<title>Project Management System Login Page</title>
</head>
<body>
 
   <!-- Bad Credentials -->
   
   <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
      <div class="container" id="badcred">           
         <c:out value="Invalid Login Credentials"></c:out>
      </div>
   </c:if>
   
 


<div class="container">
    <section id="formHolder"> 
       <div class="row"> 

          <!-- Brand Box -->
          <div class="col-sm-6 brand">
             <a href="#" class="logo"><i class="fas fa-campground"></i></a>
 
             <div class="heading">
                <h2>Project Management System</h2>
                <p>One place to manage all your projects...</p>
             </div>
 
             <div class="success-msg">
                <p></p>
             </div>
          </div>
 
 
          <!-- Form Box -->
          <div class="col-sm-6 form">
 
             <!-- Login Form -->
             <div class="login form-peice">
                <form class="login-form" action="projectlogin" method="post">

                   <div class="form-group">
					      <label for="name">User Name</label>
                     <input id="name" type="text" name="uname" class="name" required>
                     <span class="error"></span>
                   </div>
 
                   <div class="form-group">
					<label for="loginPassword">Password</label>
                    <input id="loginPassword" type="password" name="upass" class="pass" required>
                    <span class="error"></span>
                   </div>
 
                   <div class="CTA">
                      <input type="submit" value="Login">
                   </div>
				   
                </form>
             </div>
             <!-- End Login Form -->


            </div>
	    </div>
	</section>
</div>
</body>
</html>