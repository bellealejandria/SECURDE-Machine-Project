<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<nav class="navbar navbar-transparent navbar-absolute">
		<div class="container-fluid">
			<div class="navbar-header" onclick="location.href='ClickLoginServlet';">
				<button type="button" class="navbar-toggle" data-toggle="collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand">SHS Library</a>
			</div>
		</div>
	</nav>

	    <div class="main-panel">
	    	
			<div class="content">
					<c:if test="${trigger ==  1}">
					    <div class="alert alert-success">
					    	<strong>Success! </strong>Registered successfully!
						</div>
					</c:if>
					<c:if test="${trigger ==  2}">
					    <div class="alert alert-warning">
					    	<strong>Warning! </strong>Account already exists!
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
														Register
                                                        
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
                                                <form action="RegisterServlet" method="post"> 	
                                                	<div class="row">
                                                        
                                                        <div class="col-md-12">
												        <div class="form-group label-floating">
                                                            <label class="control-label">ID Number</label>
                                                            <input type="number" id="idnumber" name="idnumber" maxlength="8" min="10000000" max="20179999"  class="form-control" >
												        </div>
	                                                   </div>
                                                    </div>
                                                    
                                                     <div class="row">
                                                        <div class="col-md-4">
												        <div class="form-group label-floating">
                                                            <label class="control-label">First name</label>
                                                            <input type="text" id="firstname" name="firstName" class="form-control" >
												        </div>
	                                                   </div>
                                                         
                                                        <div class="col-md-4">
												        <div class="form-group label-floating">
                                                            <label class="control-label">Middle initial</label>
                                                            <input type="text" id="midinit" maxlength="2" name="midInitial" class="form-control" >
												        </div>
	                                                   </div>
                                                         
                                                        <div class="col-md-4">
												        <div class="form-group label-floating">
                                                            <label class="control-label">Last name</label>
                                                            <input type="text" id="lastname" name="lastName" class="form-control" >
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-12"><label class="control-label">Birthday</label>
                                                            <div class="form-group label-floating">
												                
                                                                <input type="date" id="bday" name="birthday" class="form-control" >
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
                                                            <input type="password" id="password" name="password" title="Password must be 8 characters including 1 uppercase letter, 1 lowercase letter and numeric characters" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" class="form-control" >
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
                                                           <input type="text" id="secans" name="secretAns" class="form-control" >
												        </div>
	                                                   </div>
                                                    
                                                    </div>
                                                    
                                                
                                                 <button type="submit" name="register" onClick="return empty()" class="btn btn-block btn-success">Sign Up</button>
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
		    var idnum, fname, mname, lname, email, bday, password, secans;
		    
		    idnum = document.getElementById("idnumber").value;
		    fname = document.getElementById("firstname").value;
		    mname = document.getElementById("midinit").value;
		    lname = document.getElementById("lastname").value;
		    email = document.getElementById("email").value;
		    bday = document.getElementById("bday").value;
		    password = document.getElementById("password").value;
		    secans = document.getElementById("secans").value;
		  
		    if (idnum == "" || fname == "" || mname == "" || lname == "" || email == "" || bday == "" || password == "" || secans == "" ) {
		        alert("Fields cannot be empty");
		        return false;
		    };
		}
	</script>	
</html>