<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<!-- header jsp -->
<jsp:include page="partials/header.jsp"></jsp:include>

<!-- bootstrap js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
	
<!-- bootstrap css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
<!-- Animate on scroll  -->
<script src="https://unpkg.com/aos@next/dist/aos.js"></script>

<!-- aos css used for scroll effects (aos-animate on scroll)-->
<link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />

<!-- font -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300&family=Roboto:wght@100;300&display=swap" rel="stylesheet">
<!-- icon pack -->
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

<!-- Data table -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>

<!--  jsp formatter for date-->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<meta charset="ISO-8859-1">
<title>Dashboard</title>

<!--my custom css -->
<style>
    <%@include file="public/stylesheets/home.css"%>
</style>

</head>
<body>

    <!-- Created Project , Update Project Success Messages -->
     
     
	<%
	if (request.getParameter("success") != null) {
	%>

	<div class="alert alert-success alert-dismissible fade show"
		role="alert"
		style="margin-top: 2rem; width: max-content; margin-inline: auto;">
		<%=request.getParameter("success")%>
		<button type="button" class="message" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<%
	}
	%>


    <!--  Search Bar  -->
	<div class="rest">
		<div>
			<form action="home" method="post">
				<input type="text" name="keyword" class="form-control"
					placeholder="Search A Project">
				<button class="btn btn-primary">Search</button>
				<button type="reset" class="btn btn-primary">RESET</button>
			</form>
		</div>


        <!-- Display All Projects  -->

		<h1>PROJECTS</h1>


		<div id="sp">
			<div class="row">
				<c:forEach items="${project}" var="project">
					<c:if test="${loggedinuser==project.createdBy}">
						<div class="col-md-12">
							<div class="card" data-aos="fade-left">
								<div class="row">
									<div class=col-md-4>
										<img class="img-fluid"
											src="https://i.pinimg.com/564x/37/aa/87/37aa8725510aac487fa585278f1a884b.jpg">
									</div>

									<div class="col-md-8">
										<div class="row">
										
											<div class="caption">
												<h4>${project.projectName}</h4>
											</div>
											
											<div class="col-md-6">

												<c:set var="status" value="${project.projectStatus}" />
												<c:if test="${(status=='Completed')}">												
													<h5> <span class="badge badge-success bg-success">STATUS : ${project.projectStatus}</span></h5>
												</c:if>
												<c:if test="${(status=='Not Started')}">												
													<h5> <span class="badge badge-danger bg-danger">STATUS : ${project.projectStatus}</span></h5>
												</c:if>
												<c:if test="${(status=='In Progress')}">												
													<h5> <span class="badge badge-warning bg-warning">STATUS : ${project.projectStatus}</span></h5>
												</c:if>
												
												
												<h5>CLIENT: ${project.clientName}</h5>
												<h5>START DATE: <fmt:formatDate type = "date" value = "${project.startDate}" /></h5>
												<h5>END DATE: <fmt:formatDate type = "date" value = "${project.endDate}" /></h5>
												<c:set var="resources" value="${project.resourcesAllocated}"
													scope="application" />
												<c:set var="users" value="${fn:split(resources,',')}" />

												<p>
										
												<!-- Edit button  -->
												<c:if test="${project.projectStatus=='Not Started' || project.projectStatus=='In Progress'}">												
												<a class="btn btn-sm edit" href="updateProject/${project.projectId}"> <i	class="fa fa-pencil-square"></i> Edit</a>											
												</c:if>											
													
												<c:if test="${project.projectStatus=='Completed'}">												
													<button disabled="disabled" class="btn btn-sm edit dis"> <i class="fa fa-pencil-square"></i> Edit</button>
												</c:if>
												
												<!-- Delete Button  -->
												<c:if test="${project.projectStatus=='Not Started'}">												
												<a class="btn btn-sm del"
													onclick="document.getElementById('id01-${project.projectId}').style.display='block'">
													<i class="fa fa-trash"></i> Delete
												</a>
												</c:if>
												
												<c:if test="${project.projectStatus=='Completed' || project.projectStatus=='In Progress'}">												
													<button disabled="disabled" class="btn btn-sm del dis"> <i class="fa fa-trash"></i> Delete</button>
												</c:if>
										
									
									            </p>

											</div>
											
											<div class="col-md-6 tab">												
												<table id="table_id" class="table_id table table-striped" border="1">
												<thead class="thead-dark">
													<tr class="table-dark">
														<th>Resources Allocated</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${users}" var="user">
														<tr>
															<td>${user}</td>
														</tr>
													</c:forEach>
												</tbody>
											    </table>
											</div>
										</div>
										
										
										

                                        <!-- Delete Modal -->
                                                                                
										<div id="id01-${project.projectId}" class="modal">
											<span
												onclick="document.getElementById('id01-${project.projectId}').style.display='none'"
												class="close" title="Close Modal">x</span>
											<form class="modal-content"
												action="deleteProject/${project.projectId}">
												<div class="container">
													<h1>Delete Project</h1>
													<p>Are you sure you want to delete your project : "${project.projectName}" ?</p>

													<div class="clearfix">
														<button type="button"
															onclick="document.getElementById('id01-${project.projectId}').style.display='none'"
															class="cancelbtn">Cancel</button>
														<button class="deletebtn">Confirm</button>
													</div>
												</div>
											</form>
										</div>
										
										

									</div>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	
	
	<script>
	
	/* Animate on scroll */
		AOS.init({
			offset : 150,
			duration : 1000
		});
		let list = `${project[0].projectName}`;
		console.log(list);
		
	/* resources allocated */
		$('.table_id').DataTable({
			"order": [
			[0, "desc"]
			],
			"paging":false,
			"info":false,
			"scrollY": "10vh",
			"scrollCollapse": true}
			);
	
	</script>
	
	
</body>
</html>