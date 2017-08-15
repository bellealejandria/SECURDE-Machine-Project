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
			    	<strong>Warning! </strong>Invalid ID Number!
				</div>
			</c:if>
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    
                        <div class="card-content">
                            <div class="tab-content">
                                <div class="tab-pane active" id="">
                                    <div class="card-content table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-warning">
                                                <th>ID Number</th>
                                                <th>Room Code</th>
                                                <th>Start</th>
                                                <th>End</th>
                                                <th>Action</th>
                                            </thead>
                                            <tbody>
                                            	<c:forEach items="${listOfReserveRooms}" var="resroom">
                                            		<form action="OverrideRoomServlet" method="post">
	                                                <tr>
	                                                	<td><input type="number" id="idnumber" name="idnumber" value="${resroom.idNumber}"></td>
	                                                    <td><input type="text" id="roomcode" name="roomcode" value="${resroom.roomCode}" readonly="readonly"></td>
	                                                    
	                                                    <td><input type="text" id="timeFrom" name="timeFrom" value="${resroom.timeFrom}" readonly="readonly"></td>
	                                                    <td><input type="text" id="timeTo" name="timeTo" value="${resroom.timeTo}" readonly="readonly"></td>
	                                                    
	                                                    <td>
                                                            <button type="submit" name="edit" value="${resroom.roomCode}" class="btn btn-primary btn-round">Edit</button>
                                                            <button type="submit" name="delete" value="${resroom.roomCode}" class="btn btn-danger btn-round">Delete</button>
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