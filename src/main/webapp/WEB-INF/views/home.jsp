<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>

		<thead>
		<tr>
		<th> Project Id </th>
		<th> Project Name </th>
		<th> Project Status </th>
		<th> Project Client Name </th>
		</tr>
		</thead>
		
		
		
		<c:forEach items="${project}" var="project">
		<tr>
		<td> ${project.projectId} </td>
		<td> ${project.projectName} </td>
		<td> ${project.status} </td>
		<td> ${project.clientName} </td>
		
		</tr>
		</c:forEach>
	</table>

</body>
</html>