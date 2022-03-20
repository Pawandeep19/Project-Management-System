<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <!-- header jsp -->
	<jsp:include page="partials/header.jsp"></jsp:include>
	<!-- our css -->
	<style> <%@include file="public/stylesheets/createProject.css"%> </style>
	
<meta charset="ISO-8859-1">
<title>Update Project</title>
</head>
<body>


<div class="rest">
	<div id="container">
	
	<h1>UPDATE PROJECT</h1>
	
	<form:form id="form" class="topBefore" action="../updateProject" method="post"
	modelAttribute="projectDto">
			
	<form:hidden path="id"/><br/>	
	
	Enter project name:<form:input path="projectName"/>
	Enter start date:<form:input type="date" path="startDate" />
	Enter end date :<form:input type="date" path="endDate" />
		<label for="status">Project Status:</label>
		<select name="projectStatus" id="status">
		  <option value="Not Started">Not Started</option>
		  <option value="In Progress">In Progress</option>
		  <option value="Completed">Completed</option>
		 </select>
		 </br>
	Enter client name:<form:input path="clientName" />
	Enter resources allocated:<form:input path="resourcesAllocated" />
	
	<form:hidden path="createdBy" value="${loggedinuser}"/><br/>
	
	 <input type="submit" value="SAVE"/>
	 <input type="reset" value="RESET"/>
	
	
	</form:form>
</div>		
</div>

<script>


var isSubmitting = false

$(document).ready(function () {
    $('form').submit(function(){
        isSubmitting = true
    })

    $('form').data('initial-state', $('form').serialize());

    $(window).on('beforeunload', function() {
        if (!isSubmitting && $('form').serialize() != $('form').data('initial-state')){
            return 'You have unsaved changes which will not be saved.'
        }
    });
})
</script>	
</body>
</html>