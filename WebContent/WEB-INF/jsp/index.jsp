<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% int timeout = session.getMaxInactiveInterval(); response.setHeader("Refresh", timeout + "; URL = expiredpage.html"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>SHS Library</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="bootstrap/css/custom.min.css" rel="stylesheet" />
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="bootstrap/css/library.css" rel="stylesheet"/>

    <link href="bootstrap/fonts/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>

<body>
<c:if test="${sessionScope.idNumber ==  null}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  null}"><c:redirect url="erroracct.html"></c:redirect></c:if>

<div class="wrapper">
	<nav class="navbar navbar-transparent navbar-absolute">
		<div class="container-fluid">
			<div class="navbar-header" onclick="location.href='HomeServlet';">
				<button type="button" class="navbar-toggle" data-toggle="collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">SHS Library</a>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="material-icons">dashboard</i>
							<p class="hidden-lg hidden-md">Main Menu</p>
						</a>
						<ul class="dropdown-menu">
							<c:choose> 
								<c:when test="${sessionScope.role == 'admin'}">
									<li onclick="location.href='AdminCreateStaffServlet';"><a>Create Staff</a></li>
									<li onclick="location.href='AdminExportServlet';"><a>Export</a></li>
									<li onclick="location.href='ChangePassServlet';"><a>Change Password</a></li>
									<li onclick="location.href='GoToUnlockServlet';"><a>Unlock account</a></li>
								</c:when>

								<c:when test="${sessionScope.role == 'mngr'}">
									<li onclick="location.href='MngrGoToAddBookServlet';"><a>Add Book</a></li>
									<li onclick="location.href='MngrEditBookServlet';"><a>Edit Book</a></li>
									<li onclick="location.href='MngrOverBookServlet';"><a>Override Book Reservations</a></li>
									<li onclick="location.href='MngrOverRoomServlet';"><a>Override Room Reservations</a></li>
									<li onclick="location.href='AdminExportServlet';"><a>Export</a></li>
									<li onclick="location.href='ChangePassServlet';"><a>Change Password</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'staff'}">
									<li onclick="location.href='StaffAddBookServlet';"><a>Add Book</a></li>
									<li onclick="location.href='StaffEditBookServlet';"><a>Edit Book</a></li>
									<li onclick="location.href='StaffViewRoomServlet';"><a>View Rooms</a></li>
									<li onclick="location.href='ChangePassServlet';"><a>Change Password</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'stud'}">
									<li onclick="location.href='StudResBookServlet';"><a>Reserve Book</a></li>
									<li onclick="location.href='StudResRoomServlet';"><a>Reserve Room</a></li>
									<li onclick="location.href='ChangePassServlet';"><a>Change Password</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'fac'}">
									<li onclick="location.href='FacResBookServlet';"><a>Reserve Book</a></li>
									<li onclick="location.href='FacResRoomServlet';"><a>Reserve Room</a></li>
									<li onclick="location.href='ChangePassServlet';"><a>Change Password</a></li>
								</c:when>
							</c:choose>
						</ul>
					</li>
					<li class="dropdown" onclick="location.href='LogOutServlet';">
						<a>
							<i class="material-icons">exit_to_app</i>
							<p class="hidden-lg hidden-md">Log out</p>
						</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>

	<div class="main-panel">
		<div class="content">
			<c:if test="${trigger ==  1}">
			    <div class="alert alert-success">
			    	<strong>Success! </strong>CSV files are created successfully!
				</div>
			</c:if>
			<c:choose> 
				
				<c:when test="${sessionScope.role == 'admin'}">	   
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='AdminCreateStaffServlet';">
							<a>
							<div class="card card-stats">
							<div class="card-content"  data-background-color="green">
							<center><h3 class="title">Create Staff</h3></center>

							</div>

							</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='AdminExportServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="orange">
										<center><h3 class="title">Export</h3></center>
									</div>
								</div>
							</a>
						</div>
						</div>
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='ChangePassServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="blue">
										<center><h3 class="title">Change Password</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='GoToUnlockServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="red">
										<center><h3 class="title">Unlock Account</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:when>

				<c:when test="${sessionScope.role == 'mngr'}">	   
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='MngrGoToAddBookServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="green">
										<center><h3 class="title">Add Book</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='MngrEditBookServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="orange">
										<center><h3 class="title">Edit Book</h3></center>
									</div>
								</div>
							</a>
						</div>

						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='MngrOverBookServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="red">
										<center><h3 class="title">Override Book Reservations</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='MngrOverRoomServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="blue">
										<center><h3 class="title">Override Room Reservations</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='AdminExportServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="purple">
										<center><h3 class="title">Export</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='ChangePassServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="orange">
										<center><h3 class="title">Change Password</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:when>
				
				<c:when test="${sessionScope.role == 'staff'}">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='StaffAddBookServlet';">	
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="green">
										<center><h3 class="title">Add Book</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='StaffEditBookServlet';">	
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="red">
										<center><h3 class="title">Edit Book</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='StaffViewRoomServlet';">	
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="blue">
										<center><h3 class="title">View Meeting Rooms</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='ChangePassServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="purple">
										<center><h3 class="title">Change Password</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>

				</c:when>
				
				
				<c:when test="${sessionScope.role == 'stud'}">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='StudResBookServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content" data-background-color="red">
										<center><h3 class="title">Reserve Book</h3></center>
									</div>
								</div>
							</a>
						</div>

						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='StudResRoomServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="blue">
										<center><h3 class="title">Reserve Meeting Room</h3></center>
									</div>
								</div>
							</a>
						</div>
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='ChangePassServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="purple">
										<center><h3 class="title">Change Password</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:when>

				<c:when test="${sessionScope.role == 'fac'}">
					<div class="row">

						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='FacResBookServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="red">
										<center><h3 class="title">Reserve Book</h3></center>
									</div>
								</div>
							</a>
						</div>
						
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='FacResRoomServlet';">
							<a>
							<div class="card card-stats">
								<div class="card-content"  data-background-color="blue">
									<center><h3 class="title">Reserve Meeting Room</h3></center>
								</div>
							</div>
							</a>
						</div>
						
						<div class="col-lg-3 col-md-6 col-sm-6" onclick="location.href='ChangePassServlet';">
							<a>
								<div class="card card-stats">
									<div class="card-content"  data-background-color="purple">
										<center><h3 class="title">Change Password</h3></center>
									</div>
								</div>
							</a>
						</div>
					</div>
				</c:when>
			</c:choose>
		</div>

		<footer class="footer">
			<div class="container-fluid">
				<p class="copyright pull-left">
				&copy; <script>document.write(new Date().getFullYear())</script> Alejandria | Panganiban
				</p>
			</div>
		</footer>

	</div>
</div>
</body>

    <!--   Core JS Files   -->
    <script src="bootstrap/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/material.min.js" type="text/javascript"></script>
    

    <!--  Notifications Plugin    -->
    <script src="bootstrap/js/bootstrap-notify.js"></script>

    <!-- Material Dashboard javascript methods -->
    <script src="bootstrap/js/material-dashboard.js"></script>

</html>
