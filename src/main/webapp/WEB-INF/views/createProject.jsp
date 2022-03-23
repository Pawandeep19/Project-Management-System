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
	<style> <%@include file="public/stylesheets/forms.css"%> </style>

	<meta charset="ISO-8859-1">
	<title>Create New Project</title>
</head>
<body>




<div class="rest">
	<div id="container">
	
	<h1>CREATE NEW PROJECT</h1>
	 
	 <!-- Create new project form  -->
	<form:form id="form" class="topBefore" action="addproject" method="post"
		modelAttribute="project">
	
		Enter project name:<form:input required="required" maxlength="30" path="projectName" />
		
		Enter start date:<form:input required="required" id="startdate" type="date" path="startDate" />
		
		Enter end date :<form:input required="required" id="enddate" type="date" path="endDate" />
		
		<label for="status">Project Status:</label>
		<select name="projectStatus" required="required" id="status">
		  <option value="Not Started">Not Started</option>
		  <option value="In Progress">In Progress</option>
		  <option value="Completed">Completed</option>
		 </select>
		 </br>
		Enter client name:<form:input required="required" maxlength="30" path="clientName" />
		Enter resources allocated like , Eg: Pawan, Akshat, Paras,...<form:input required="required" path="resourcesAllocated" />
		<form:hidden path="createdBy" value="${loggedinuser}"/>
		
		<input type="submit" value="SAVE" />
		<input type="reset" value="RESET">
		
	</form:form>
    </div>
</div>



<script>


var isSubmitting = false

$(document).ready(function () {
    $('form').submit(function(ev){
    	
    	/* Start date should be less than End date validation */

		if(Date.parse($('#startdate').val()) < Date.parse($('#enddate').val())){ 
			isSubmitting = true;
		 }
		else{
			alert('startdate should be lesser than enddate');
			ev.preventDefault();
		} 
    })
    

    $('form').data('initial-state', $('form').serialize());

    $(window).on('beforeunload', function() {
    	
    	/* Leaving the page without saving - Warning */
    	
		if (!isSubmitting && $('form').serialize() != $('form').data('initial-state')){
            return 'You have unsaved changes which will not be saved.'
        }
		
    });
})
</script>

</body>
</html>