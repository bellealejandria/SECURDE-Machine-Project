<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	
	
	
	<div class="wrapper">
	    <div class="main-panel">
		    <c:if test="${trigger ==  1}">
			    <c:choose>
					<c:when test="${numTry > 1}">
				        <div class="alert alert-warning">
					    	<strong>Warning! </strong><c:out value="${numTry}"></c:out> attempts left!
						</div>
					</c:when>
					<c:when test="${numTry == 1}">
				        <div class="alert alert-warning">
					    	<strong>Warning! </strong>Last attempt left!
						</div>
					</c:when>
					<c:when test="${numTry == 0}">
						<div class="alert alert-danger">
					    	<strong>Warning! </strong>Account locked! Please contact the administrator.
						</div>
					</c:when>
					<c:when test="${numTry < 0}">
						<div class="alert alert-danger">
					    	<strong>Warning! </strong>Incorrect username/password!
						</div>
					</c:when>
				</c:choose>
			</c:if>
			
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
														Login
                                                        
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
                                                            <label class="control-label">Username</label>
                                                            <input type="number" id="idnumber" class="form-control" name="idnumber">
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                    
                                                    <div class="row">
                                                        
                                                        <div class="col-md-12">
												        <div class="form-group label-floating">
                                                            <label class="control-label">Password</label>
                                                            <input type="password" id="password" class="form-control" name="password">
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                
                                                 <button type="submit" name="login" onclick="return empty()" class="btn btn-block btn-success">Login</button>
                                                 <button type="submit" name="signup" class="btn btn-block btn-primary">Register</button>
                                                
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
		    var idnum, pw;
		    
		    idnum = document.getElementById("idnumber").value;
		    pw = document.getElementById("password").value;
		   
		    if (idnum == "" || pw == "") {
		        alert("Fields cannot be empty");
		        return false;
		    };
		}
	</script>	

</html>


