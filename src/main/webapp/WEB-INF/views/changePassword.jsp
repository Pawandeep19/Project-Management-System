<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Project Management System Change Password</title>	
	
			<!-- bootstrap css -->
			<link rel="stylesheet"
				href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
				integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
				crossorigin="anonymous">
			
			<!-- jquery -->
			<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
				integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
				crossorigin="anonymous"></script>
			
			<!-- popper.js -->
			<script
				src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
				integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
				crossorigin="anonymous"></script>
			
			<!-- bootstrap js -->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
				integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
				crossorigin="anonymous"></script>
			
			<!-- header jsp -->
			<jsp:include page="partials/header.jsp"></jsp:include>
			
			<!-- my custom css -->
			<style> <%@include file="public/stylesheets/forms.css"%> </style>
	
	</head>



<body>

	<div class="rest">
		<div id="container">
			<h1>CHANGE PASSWORD</h1>
             
             <!-- Password changed success message -->
			<%
			if (request.getParameter("success") != null) {
			%>

			<div class="alert alert-success alert-dismissible fade show"
				role="alert"
				style="margin-top: 2rem; width: max-content; margin-inline: auto;">
				<%=request.getParameter("success")%>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%
			}
			%>
            
            <!-- Password error message -->

			<%
			if (request.getParameter("error") != null) {
			%>
			<div class="alert alert-danger alert-dismissible fade show"
				role="alert"
				style="margin-top: 2rem; width: max-content; margin-inline: auto;">
				<%=request.getParameter("error")%>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<%
			}
			%>
             
             
             <!-- Change Password form -->

			<form:form id="form" class="topBefore" action="changepwd" method="post" modelAttribute="changePassword">
			    Enter current password:<form:input type="password" path="currPassword" required="required" />
				
				Enter new password:<form:input type="password" path="newPassword" required="required" />
				
				Confirm new password :<form:input type="password" path="confirmPassword" required="required"/>

				<button type="submit">Change Password</button>

			</form:form>
			
			
		</div>
	</div>

</body>
</html>