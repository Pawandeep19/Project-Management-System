<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Project</title>
</head>
<body>
	<form:form action="addproject" method="post"
		modelAttribute="project">
	
	Enter project name:<form:input path="projectName" />
		<br />
	<%--  Enter start date:<form:input path="startDate" />
		<br />
	Enter end date :<form:input path="endDate" />
		<br />  --%>
	Enter status:<form:input path="status" />
		<br />
	Enter client name:<form:input path="clientName" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>