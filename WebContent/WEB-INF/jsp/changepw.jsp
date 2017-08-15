<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% int timeout = session.getMaxInactiveInterval(); response.setHeader("Refresh", timeout + "; URL = expiredpage.html"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Library</title>

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
				    <div class="alert alert-warning">
				    	<strong>Warning! </strong>Invalid password!
					</div>
				</c:if>
				<c:if test="${trigger ==  2}">
				    <div class="alert alert-success">
				    	<strong>Success! </strong>Password changed!
					</div>
				</c:if>
					<div class="row">
                        <div class="col-md-4">
                        
                        </div>
                            
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
														Change Password
                                                        
													<div class="ripple-container"></div></a>
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
                                                <form action="LoginServlet" method="post"> 
                                                    <div class="row">
                                                        
                                                        <div class="col-md-12">
												        <div class="form-group label-floating">
                                                            <label class="control-label">Old Password</label>
                                                            <input type="password" class="form-control" id="oldpw" name="oldpw">
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                    
                                                    <div class="row">
                                                        
                                                        <div class="col-md-12">
												        <div class="form-group label-floating">
                                                            <label class="control-label">New Password</label>
                                                            <input type="password" class="form-control" id="newpw" name="newpw"  title="Password must be 8 characters including 1 uppercase letter, 1 lowercase letter and numeric characters" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}">
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                
                                                 <button type="submit" onClick="return empty()" name="save" class="btn btn-block btn-success">Save</button>
                                                 
	                                             <div class="clearfix"></div>
                                                
                                                </form>
                                            </div>
                                            
										</div>
										
									</div>
								</div>
							</div>
						</div>
                            
                        <div class="col-md-4">
                        
                        </div>

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
	    var oldpw, newpw;
	    
	    oldpw = document.getElementById("oldpw").value;
	    newpw = document.getElementById("newpw").value;
	  
	    if (oldpw == "" || newpw == "") {
	        alert("Fields cannot be empty");
	        return false;
	    };
	}
	
	</script>
</html>


