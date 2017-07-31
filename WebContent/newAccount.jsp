<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Create New Account</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="bootstrap/css/custom.min.css" rel="stylesheet" />
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="bootstrap/css/library.css" rel="stylesheet"/>

    <link href="bootstrap/fonts/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="wrapper">
	<nav class="navbar navbar-transparent navbar-absolute">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/HomeServlet">SHS Library</a>
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
									<li><a href="${pageContext.request.contextPath}/AdminGoToServlet?action=newacct">Create Staff</a></li>
									<li><a href="#">Export</a></li>
								</c:when>

								<c:when test="${sessionScope.role == 'mngr'}">
									<li><a href="${pageContext.request.contextPath}/MngrGoToServlet?action=addbook">Add Book</a></li>
									<li><a href="${pageContext.request.contextPath}/MngrGoToServlet?action=editbook">Edit Book</a></li>
									<li><a href="#">Override Book Reservations</a></li>
									<li><a href="#">Override Room Reservations</a></li>
									<li><a href="#">Export</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'staff'}">
									<li><a href="${pageContext.request.contextPath}/StaffGoToServlet?action=addbook">Add Book</a></li>
									<li><a href="${pageContext.request.contextPath}/StaffGoToServlet?action=editbook">Edit Book</a></li>
									<li><a href="#">View Books</a></li>
									<li><a href="#">View Meeting Rooms</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'stud'}">
								<li><a href="#">Reserve Book</a></li>
								<li><a href="#">Reserve Meeting Room</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'fac'}">
								<li><a href="#">Reserve Book</a></li>
								<li><a href="#">Reserve Meeting Room</a></li>
								</c:when>
							</c:choose>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
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
			<div class="row">
				<div class="col-md-4"></div>

				<div class="col-md-4">
					<div class="card card-nav-tabs">
						<div class="card-header" data-background-color="purple">
							<div class="nav-tabs-navigation">
								<div class="nav-tabs-wrapper">
									<ul class="nav nav-tabs" data-tabs="tabs">
										<center>
											<li class="active">
												<a href="#profile" data-toggle="tab">
													<i class="material-icons">vpn_key</i>
													New Account
													<div class="ripple-container"></div>
												</a>
											</li>
										</center>
									</ul>
								</div>
							</div>
						</div>

						<div class="card-content">
							<div class="tab-content">
								<div class="tab-pane active" id="profile">

									<div class="card-content table-responsive">
										<form action="NewAccountServlet" method="post"> 	
											<div class="row">
												<div class="col-md-6">
													<label class="control-label">Position</label>
													<div class="form-group label-floating">
														<select name="position" class="form-control" >
															<option value="1">Library Manager</option>
															<option value="2">Library Staff</option>
														</select>
													</div>
												</div>

												<div class="col-md-6">
													<label class="control-label">ID Number</label>
													<div class="form-group label-floating">
														<input type="number" id="idnumber" name="idnumber" maxlength="8" min="20000000" max="20179999" class="form-control" >
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-4">
													<div class="form-group label-floating">
														<label class="control-label">First name</label>
														<input type="text" id="firstName" name="firstName" class="form-control" >
													</div>
												</div>

												<div class="col-md-4">
													<div class="form-group label-floating">
														<label class="control-label">Middle initial</label>
														<input type="text" id="midInitial" maxlength="2" name="midInitial" class="form-control" >
													</div>
												</div>

												<div class="col-md-4">
													<div class="form-group label-floating">
														<label class="control-label">Last name</label>
														<input type="text" id="lastName" name="lastName" class="form-control" >
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-12"><label class="control-label">Birthday</label>
													<div class="form-group label-floating">
														<input type="date" id="birthday" name="birthday" class="form-control" >
													</div>
												</div>
											</div>
											
											<div class="row">
												<div class="col-md-12">
													<div class="form-group label-floating">
														<label class="control-label">E-mail</label>
														<input type="email" id="email" name="email" class="form-control" >
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-12">
													<div class="form-group label-floating">
														<label class="control-label">Password</label>
														<input type="password" id="password" name="password" class="form-control" >
													</div>
												</div>
											</div>  

											<div class="row">
												<div class="col-md-6">
													<label class="control-label">Secret Question</label>
													<div class="form-group label-floating">
														<select name="secretQuestion" class="form-control" >
															<option>What was your childhood nickname?</option>
															<option>What is your favorite movie?</option>
															<option>What is the name of your favorite pet?</option>
															<option>What street did you grow up on?</option>
															<option>What is your mother's maiden name?</option>
														</select>
													</div>
												</div>

												<div class="col-md-6">
													<label class="control-label">Secret Answer</label>
													<div class="form-group label-floating">
														<input type="password" id="secretAns" name="secretAns" class="form-control" >
													</div>
												</div>
											</div>


											<button type="submit" name="createAcct"  onClick="return empty()" class="btn btn-block btn-success">Create Account</button>
											<div class="clearfix"></div>

										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4"></div>

			</div>
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
	
	<script>
		function empty() {
		    var id, fn, mi, ln, bday, email, pw, secAns;
		    
		    id = document.getElementById("idnumber").value;
		    fn = document.getElementById("firstName").value;
		    mi = document.getElementById("midInitial").value;
		    ln = document.getElementById("lastName").value;
		    bday = document.getElementById("birthday").value;
		    email = document.getElementById("email").value;
		    pw = document.getElementById("password").value;
		    secAns = document.getElementById("secretAns").value;
		    
		    if (id == "" || fn == "" || mi == "" || ln == "" || bday == "" || email == "" || pw == "" || secAns == "") {
		        alert("Fields cannot be empty");
		        return false;
		    };
		}
	</script>	

</html>