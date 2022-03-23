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
<title>Update Project</title>
</head>
<body>


<div class="rest">
	<div id="container">
	
	<h1>UPDATE PROJECT : <span> ${projectDto.projectName} </span></h1>
	
	<!-- Create new project form  -->
	
	<form:form id="form" class="topBefore" action="../updateProject" method="post"
	modelAttribute="projectDto">
			
	<form:hidden path="id"/><br/>	
	
	Enter project name:<form:input required="required" maxlength="30" path="projectName"/>
	Enter start date:<form:input required="required" type="date" path="startDate" id="startdate" />
	Enter end date :<form:input required="required" type="date" path="endDate" id="enddate" />
		<label for="status">Project Status:</label>
		<select name="projectStatus" required="required" id="status">
		<c:set var="status" value="${projectDto.projectStatus}"/>		
		<c:if test="${(status=='Not Started')}">		
		  <option value="Not Started">Not Started</option>
		</c:if>
		  <option value="In Progress">In Progress</option>
		  <option value="Completed">Completed</option>
		 </select>
		 </br>
	Enter client name:<form:input required="required" maxlength="30" path="clientName" />
	Enter resources allocated like , Eg: Pawan, Akshat, Paras,..<form:input required="required" path="resourcesAllocated" />
	
	<form:hidden path="createdBy" value="${loggedinuser}"/><br/>
	
	 <input id="submit" type="submit" value="SAVE" disabled="disabled"/>
	 <input id="reset" type="reset" value="RESET"/>
	
	
	</form:form>
	
	
</div>		
</div>

<script>

/* Save button disabled if no changes made */
$(document).on("change", "form", 
		    function(){ 
     $("#submit").prop("disabled",false);
     $("#submit").css("background-color", "transparent");
     $("#submit").css("cursor", "pointer");
     $("#submit").css("color", "black");
     $("#submit").hover(function(){
  	   $(this).css("background-color", "green");
  	   }, function(){
  	   $(this).css("background-color", "transparent");
  	 });
     
     $("#reset").prop("disabled",false);
     $("#reset").css("background-color", "transparent");
     $("#reset").css("cursor", "pointer");
     $("#reset").css("color", "black");
     $("#reset").hover(function(){
  	   $(this).css("background-color", "red");
  	   }, function(){
  	   $(this).css("background-color", "transparent");
  	 });
  } 
);
 

/* Leaving the page without saving - Warning */

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