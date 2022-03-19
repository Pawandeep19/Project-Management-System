<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

	<!-- header jsp -->
	<jsp:include page="partials/header.jsp"></jsp:include>
	<!-- bootstrap js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <!-- bootstrap css -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Dashboard</title>

	<!-- css -->
	<style>
	#sp{
		margin:0 100px;;
	}
	.card{
		border: none;
		box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
		margin-bottom: 50px;
	
	}
	.edit{
		background-color:rgb(0, 162, 255);
		color: white;
		margin-left:20px;
	}
	.del{
		background-color:red;
		color: white;
		margin-left: 80px;
	}


	h4{
		background-color: #442c2e;
		color: white;
		text-align: center;
		text-transform: uppercase;
		padding: 0;
		margin-top: 5px;
		margin-bottom: 5px;
	}
	
			* {box-sizing: border-box;}
		
		/* Set a style for all buttons */
		button {
		  background-color: #04AA6D;
		  color: white;
		  padding: 14px 20px;
		  margin: 8px 0;
		  border: none;
		  cursor: pointer;
		  width: 100%;
		  opacity: 0.9;
		}
		
		button:hover {
		  opacity:1;
		}
		
		/* Add a color to the cancel button */
		.cancelbtn {
		  background-color: #ccc;
		  color: black;
		}
		/* Float cancel and delete buttons and add an equal width */
		.cancelbtn, .deletebtn {
		  float: left;
		  width: 50%;
		
		}
		
		
		/* Add a color to the delete button */
		.deletebtn {
		  background-color: #f02315;
		}
		
		/* Add padding and center-align text to the container */
		.container {
		  padding: 16px;
		  text-align: center;
		}
		
		/* The Modal (background) */
		.modal {
		  display: none; /* Hidden by default */
		  position: fixed; /* Stay in place */
		  z-index: 1; /* Sit on top */
		  left: 0;
		  top: 0;
		  width: 100%; /* Full width */
		  height: 100%; /* Full height */
		  overflow: auto; /* Enable scroll if needed */
		  background-color: #474e5d;
		  padding-top: 50px;
		}
		
		/* Modal Content/Box */
		.modal-content {
		  background-color: #fefefe;
		  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
		  border: 1px solid #888;
		  width: 80%; /* Could be more or less, depending on screen size */
		}
		
		/* Style the horizontal ruler */
		hr {
		  border: 1px solid #f1f1f1;
		  margin-bottom: 25px;
		}
		 
		/* The Modal Close Button (x) */
		.close {
		  position: absolute;
		  right: 35px;
		  top: 15px;
		  font-size: 40px;
		  font-weight: bold;
		  color: #f1f1f1;
		}
		
		.close:hover,
		.close:focus {
		  color: #f44336;
		  cursor: pointer;
		}
		
		/* Clear floats */
		.clearfix::after {
		  content: "";
		  clear: both;
		  display: table;
		}
		
		/* Change styles for cancel button and delete button on extra small screens */
		@media screen and (max-width: 300px) {
		  .cancelbtn, .deletebtn {
		     width: 100%;
		  }
		}

	</style>
	<!-- css over -->
	
</head>
<body>

<div class="rest">    
<div id="sp">
	<div class="row">  		
		<c:forEach items="${project}" var="project">
		<c:if test="${loggedinuser==project.createdBy}"> 
            <div class="col-md-3 col-sm-6">
                <div class="card">
                    <img class="img-fluid" src="https://i.pinimg.com/564x/37/aa/87/37aa8725510aac487fa585278f1a884b.jpg" >
                    <div class="caption">
                       <h4>${project.projectName}</h4>
                    </div>
					<h5>Status : ${project.projectStatus}</h5>
					<h5>Client: ${project.clientName}</h5>
					<h5>Start Date: ${project.startDate}</h5>
					<h5>End Date: ${project.endDate}</h5>
					<!-- <h5>Started${project.createdBy}</h5> -->
					<p><a class="btn btn-sm edit" href="updateProject/${project.projectId}" > Edit</a>
					<a class="btn btn-sm del" onclick="document.getElementById('id01').style.display='block'"> Delete</a></p>
					
					<div id="id01" class="modal">
					  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">x</span>
					  <form class="modal-content" action="/action_page.php">
					    <div class="container">
					      <h1>Delete Account</h1>
					      <p>Are you sure you want to delete your account?</p>
					    
					      <div class="clearfix">
					        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
					        <button type="button"  href="deleteProject/${project.projectId}" onclick="document.getElementById('id01').style.display='none'" class="deletebtn" >Delete</button>
					      </div>
					    </div>
					  </form>
					</div>
					
					
					
                </div>                
            </div>  
		</c:if>
	    </c:forEach>		
	</div>
</div> 

	
</div>
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}


</script>	
</body>
</html>