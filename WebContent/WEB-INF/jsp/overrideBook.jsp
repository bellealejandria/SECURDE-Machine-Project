<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% if(session.getAttribute("idNumber") == null) response.sendRedirect("login.jsp");	
int timeout = session.getMaxInactiveInterval(); response.setHeader("Refresh", timeout + "; URL = login.jsp"); %>


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
<c:if test="${sessionScope.role ==  'admin'}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  'staff'}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  'stud'}"><c:redirect url="erroracct.html"></c:redirect></c:if>
<c:if test="${sessionScope.role ==  'fac'}"><c:redirect url="erroracct.html"></c:redirect></c:if>

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
									<li><a href="#">Export</a></li>
								</c:when>

								<c:when test="${sessionScope.role == 'mngr'}">
									<li onclick="location.href='MngrAddBookServlet';"><a>Add Book</a></li>
									<li onclick="location.href='MngrEditBookServlet';"><a>Edit Book</a></li>
									<li onclick="location.href='MngrOverBookServlet';"><a>Override Book Reservations</a></li>
									<li onclick="location.href='MngrOverRoomServlet';"><a>Override Room Reservations</a></li>
									<li><a href="#">Export</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'staff'}">
									<li onclick="location.href='StaffAddBookServlet';"><a>Add Book</a></li>
									<li onclick="location.href='StaffEditBookServlet';"><a>Edit Book</a></li>
									<li onclick="location.href='StaffViewRoomServlet';"><a>View Rooms</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'stud'}">
									<li onclick="location.href='StudResBookServlet';"><a>Reserve Book</a></li>
									<li onclick="location.href='StudResRoomServlet';"><a>Reserve Room</a></li>
								</c:when>
								<c:when test="${sessionScope.role == 'fac'}">
									<li onclick="location.href='FacResBookServlet';"><a>Reserve Book</a></li>
									<li onclick="location.href='FacResRoomServlet';"><a>Reserve Room</a></li>
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
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="card card-nav-tabs">
                    <form action="SortReserveBookServlet" method="post">
                        <div class="card-header" data-background-color="purple">
                            <div class="nav-tabs-navigation">
                                <div class="nav-tabs-wrapper">
                                
                                    <ul class="nav nav-tabs" data-tabs="tabs">
                                        <div class="col-md-6">
                                            <li class="">
                                                <div class="form-group label-floating">
                                                    <select name="sortby" type="text" class="form-control text-white">
                                                        <option class="text-black" value="S1">View All</option>
                                                        <option class="text-black" value="S2">ID Number</option>
                                                        <option class="text-black" value="S3">Title</option>
                                                        <option class="text-black" value="S4">Status</option>
                                                        <option class="text-black" value="S5">Date Borrowed</option>
                                                        <option class="text-black" value="S6">Date Returned</option>
                                                    </select>
                                                </div>
                                            </li>
                                        </div>
                                        <div class="col-md-3">
                                            <li class="">
                                                <div class="form-group label-floating">
                                                    <button name="sortByBtn" type="submit" class="btn btn-success pull-right btn-round" style="margin-top: -0.5em; margin-right: 2em;">Sort</button>
                                                </div>
                                            </li>
                                        </div>
                                    </ul>
                                
                                </div>
                            </div>
                        </div>
                        
                        </form>
</div>
                        <div class="card-content">
                            <div class="tab-content">
                                <div class="tab-pane active" id="">
                                    <div class="card-content table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-warning">
                                                <th>ID Number</th>
                                                <th>Book Title</th>
                                                <th>Status</th>
                                                <th>Date Borrowed</th>
                                                <th>Date Returned</th>
                                                <th>Action</th>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${listOfReserveBooks}" var="resbook">
                                            		<form action="OverrideBookServlet" method="post">
	                                                <tr>
	                                                    <td><input type="number" id="idnumber" name="idnumber" value="${resbook.idnumber}"></td>
	                                                    <td><input type="text" id="title" name="title" value="${resbook.title}" readonly="readonly"></td>
	                                                    <td>
                                                            <select type="text" id="status" name="status">
                                                                <option value="1" ${resbook.status == 1 ? 'selected' : ''}>Reserved</option>
                                                                <option value="2" ${resbook.status == 2 ? 'selected' : ''}>Out</option>
                                                            </select>
                                                            
                                                       </td>
                                                       
	                                                    <td><input type="date" id="dateFrom" name="dateFrom" value="${resbook.dateFrom}"></td>
	                                                    <td><input type="date" id="dateTo" name="dateTo" value="${resbook.dateTo}"></td>
	                                                    
	                                                    <td>
                                                            <button type="submit" name="edit" value="${resbook.idbook_reservation}" class="btn btn-primary btn-round">Edit</button>
                                                            <button type="submit" name="delete" value="${resbook.idbook_reservation}" class="btn btn-danger btn-round">Delete</button>
                                                        </td>
	                                               </tr>
	                                               </form>
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