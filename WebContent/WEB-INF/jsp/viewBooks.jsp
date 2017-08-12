<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("idNumber") == null) response.sendRedirect("login.jsp");	
int timeout = session.getMaxInactiveInterval(); response.setHeader("Refresh", timeout + "; URL = login.jsp"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Books</title>

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
        <!--<nav class="navbar navbar-default navbar-absolute">
            
                <div class="container-fluid">
				    <img class="logo" width="50px" src="assets/img/logo.png"> Library
                </div>
            </nav>-->

	    <div class="main-panel">
			<div class="content">
				<form action="BookDetailServlet" method="post">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="card card-nav-tabs">
								<div class="card-header" data-background-color="orange">
									<div class="nav-tabs-navigation">
										<div class="nav-tabs-wrapper">
                                                <ul class="nav nav-tabs" data-tabs="tabs">
												    <div class="col-md-3">
                                                    <li class="">
													       <div class="form-group label-floating">
                                                                <select type="text" name="filter" class="form-control text-white">
                                                                	<option class="text-black" value="all">All</option>
                                                                    <option class="text-black" value="title">Title</option>
                                                                    <option class="text-black" value="author">Author</option>
                                                                    <option class="text-black" value="publisher">Publisher</option>
                                                                    <option class="text-black" value="year">Year</option>
                                                                </select>
												            </div>
                                                         </li>
                                                    </div>
                                                    <div class="col-md-6">
                                                    <li class="">
													       <div class="form-group label-floating">
                                                                <input type="text" name="stringToSearch" class="form-control text-white">
                                                            </div>
                                                         </li>
                                                    </div>
                                                    <div class="col-md-3">
                                                    <li class="">
													   <div class="form-group label-floating">
                                                                <button type="submit" name="search" class="btn btn-success pull-right btn-round" style="margin-top: -0.5em; margin-right: 2em;">Search</button>
                                                        </div>
                                                    </li>
                                                    </div>
											     </ul>
                                            
										</div>
									</div>
								</div>

								<div class="card-content">
									<div class="tab-content">
										<div class="tab-pane active" id="">
                                            <div class="card-content table-responsive">
                                                <table class="table table-hover">
                                                    <thead class="text-warning">
                                                        <th>Title</th>
                                                        <th>Author</th>
                                                        <th>Year</th>
                                                        <th>Publisher</th>
                                                        <th>Location</th>
                                                        <th>Status</th>
                                                        <th>Action</th>
                                                    </thead>
                                                    <tbody>
                                                    	<c:forEach items="${listOfBooks}" var="book">
                                                        <tr>
                                                            <td><c:out value = "${book.title}"/></td>
                                                            <td><c:out value = "${book.author}"/></td>
                                                            <td><c:out value = "${book.year}"/></td>
                                                            <td><c:out value = "${book.publisher}"/></td>
                                                            <td><c:out value = "${book.location}"/></td>
                                                            <td>
	                                                            <c:choose> 
																	<c:when test="${book.status == '0'}">
																    	Available
																    </c:when>
																    <c:when test="${book.status == '1'}">
																        Reserved
																    </c:when>
																    <c:when test="${book.status == '2'}">
																        Out
																    </c:when>
																</c:choose>
                                                            </td>
                                                            <td>
                                                            	<button type="submit" name="edit" value="${book.idBook}" class="btn btn-success btn-round">Edit</button>
                                                            	<button type="submit" name="delete" value="${book.idBook}" class="btn btn-danger btn-round">Delete</button>
                                                            </td>
                                                        </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            
										</div>
										
									</div>
								</div>
							</div>
						</div>

						
					</div>
					</form>
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