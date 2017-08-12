<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
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
<c:if test="${sessionScope.role ==  'mngr'}"><c:redirect url="erroracct.html"></c:redirect></c:if>

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
                        <div class="card-content">
                            <div class="tab-content">
                                <div class="tab-pane active" id="">
                                    <div class="card-content table-responsive">
                                        <table class="table ">
                                            <thead class="text-warning">
                                                <th>Meeting Room Number</th>
                                                <th>0800 - 0900</th>
                                                <th>0900 - 1000</th>
                                                <th>1000 - 1100</th>
                                                <th>1100 - 1200</th>
                                                <th>1200 - 1300</th>
                                                <th>1300 - 1400</th>
                                                <th>1400 - 1500</th>
                                                <th>1500 - 1600</th>
                                                <th>1600 - 1700</th>
                                            </thead>
                                            <tbody>
                                                <form action="ReserveRoomServlet" method="post">
                                                    <tr>
                                                        <td class="table-no-border">1</td>
                                                       	<c:forEach items="${ListRoom1}" var="room1">
                                                       		<c:choose>
                                                       			<c:when test="${room1.status == 0}">
                                                       				<c:choose>
	                                                       				<c:when test="${sessionScope.role == 'staff'}">
	                                                       					<td class="reserve-taken table-reserve">Available</td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'stud'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room1.roomCode}">Reserve</button></td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'fac'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room1.roomCode}">Reserve</button></td>
	                                                       				</c:when>
                                                       				</c:choose>
                                                     			</c:when>
                                                       			<c:otherwise>
                                                       				<td class="reserve-taken table-reserve">Not Available</td>
                                                       			</c:otherwise>
                                                       		</c:choose>
                                                       	</c:forEach>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-no-border">2</td>
                                                       	<c:forEach items="${ListRoom2}" var="room2">
                                                       		<c:choose>
                                                       			<c:when test="${room2.status == 0}">
                                                       				<c:choose>
	                                                       				<c:when test="${sessionScope.role == 'staff'}">
	                                                       					<td class="reserve-taken table-reserve">Available</td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'stud'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room2.roomCode}">Reserve</button></td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'fac'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room2.roomCode}">Reserve</button></td>
	                                                       				</c:when>
                                                       				</c:choose>
                                                     			</c:when>
                                                       			
                                                       			<c:otherwise>
                                                       				<td class="reserve-taken table-reserve">Not Available</td>
                                                       			</c:otherwise>
                                                       		</c:choose>
                                                       	</c:forEach>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-no-border">3</td>
                                                       	<c:forEach items="${ListRoom3}" var="room3">
                                                       		<c:choose>
                                                       			<c:when test="${room3.status == 0}">
                                                       				<c:choose>
	                                                       				<c:when test="${sessionScope.role == 'staff'}">
	                                                       					<td class="reserve-taken table-reserve">Available</td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'stud'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room3.roomCode}">Reserve</button></td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'fac'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room3.roomCode}">Reserve</button></td>
	                                                       				</c:when>
                                                       				</c:choose>
                                                     			</c:when>
                                                       			<c:otherwise>
                                                       				<td class="reserve-taken table-reserve">Not Available</td>
                                                       			</c:otherwise>
                                                       		</c:choose>
                                                       	</c:forEach>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-no-border">4</td>
                                                       	<c:forEach items="${ListRoom4}" var="room4">
                                                       		<c:choose>
                                                       			<c:when test="${room4.status == 0}">
                                                       				<c:choose>
	                                                       				<c:when test="${sessionScope.role == 'staff'}">
	                                                       					<td class="reserve-taken table-reserve">Available</td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'stud'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room4.roomCode}">Reserve</button></td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'fac'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room4.roomCode}">Reserve</button></td>
	                                                       				</c:when>
                                                       				</c:choose>
                                                     			</c:when>
                                                       			<c:otherwise>
                                                       				<td class="reserve-taken table-reserve">Not Available</td>
                                                       			</c:otherwise>
                                                       		</c:choose>
                                                       	</c:forEach>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-no-border">5</td>
                                                       	<c:forEach items="${ListRoom5}" var="room5">
                                                       		<c:choose>
                                                       			<c:when test="${room5.status == 0}">
                                                       				<c:choose>
	                                                       				<c:when test="${sessionScope.role == 'staff'}">
	                                                       					<td class="reserve-taken table-reserve">Available</td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'stud'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room5.roomCode}">Reserve</button></td>
	                                                       				</c:when>
	                                                       				<c:when test="${sessionScope.role == 'fac'}">
	                                                       					<td class="reserve-available table-reserve"><button type="submit" name="reserveroom" value="${room5.roomCode}">Reserve</button></td>
	                                                       				</c:when>
                                                       				</c:choose>
                                                     			</c:when>
                                                       			<c:otherwise>
                                                       				<td class="reserve-taken table-reserve">Not Available</td>
                                                       			</c:otherwise>
                                                       		</c:choose>
                                                       	</c:forEach>
                                                    </tr>
                                                </form>
                                            </tbody>
                                        </table>
                                    </div>      
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

