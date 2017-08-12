<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("idNumber") == null) response.sendRedirect("login.jsp");	
int timeout = session.getMaxInactiveInterval(); response.setHeader("Refresh", timeout + "; URL = login.jsp"); %>

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
<c:if test="${sessionScope.role ==  'mngr'}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  'staff'}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  'stud'}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  'fac'}"><c:redirect url="erroracct.html"></c:redirect></c:if>

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
                                    <li><a href="#">View Meeting Rooms</a></li>
                                </c:when>
                                <c:when test="${sessionScope.role == 'stud'}">
                                    <li><a href="${pageContext.request.contextPath}/StudGoToServlet?action=resbook">Reserve Book</a></li>
                                    <li><a href="${pageContext.request.contextPath}/StudGoToServlet?action=resroom">Reserve Meeting Room</a></li>
                                </c:when>
                                <c:when test="${sessionScope.role == 'fac'}">
                                <li><a href="${pageContext.request.contextPath}/FacGoToServlet?action=resbook">Reserve Book</a></li>
                                <li><a href="${pageContext.request.contextPath}/FacGoToServlet?action=resroom">Reserve Meeting Room</a></li>
                                </c:when>
                            </c:choose>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="${pageContext.request.contextPath}/LogOutServlet">
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
                                                            <input type="password" class="form-control" id="newpw" name="newpw">
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                
                                                 <button type="submit" name="save" class="btn btn-block btn-success">Save</button>
                                                 
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

</html>


