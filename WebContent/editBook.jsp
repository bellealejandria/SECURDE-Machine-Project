<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
                <div class="col-lg-12 col-md-12">
                    <div class="card card-nav-tabs">
                        <form action="SearchServlet" action="post">
                        <div class="card-header" data-background-color="purple">
                            <div class="nav-tabs-navigation">
                                <div class="nav-tabs-wrapper">
                                	
	                                    <ul class="nav nav-tabs" data-tabs="tabs">
	                                        <div class="col-md-3">
	                                            <li class="">
	                                                <div class="form-group label-floating">
	                                                    <select type="text" name="filter" class="form-control text-white">
	                                                        <option class="text-black">All</option>
	                                                        <option class="text-black" value="Title">Title</option>
	                                                        <option class="text-black" value="Author">Author</option>
	                                                        <option class="text-black" value="Publisher">Publisher</option>
	                                                        <option class="text-black" value="Year">Year</option>
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
	                                                    <button type="submit" name="searchButton" class="btn btn-success pull-right btn-round" style="margin-top: -0.5em; margin-right: 2em;">Search</button>
	                                                </div>
	                                            </li>
	                                        </div>
	                                    </ul>
                                    
                                </div>
                            </div>
                        </div>
						</form>
						
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
                                                	<form action="EditBookServlet" method="post">
                                                    <tr>
                                                        <td><input type="text" id="title" name="title" value="${book.title}"></td>
                                                        <td><input type="text" id="author" name="author" value="${book.author}"></td>
                                                        <td><input type="number" id="year" name="year" value="${book.year}"></td>
                                                        <td><input type="text" id="publisher" name="publisher" value="${book.publisher}"></td>
                                                        <td><input type="text" id="location" name="location" value="${book.location}"></td>
                                                        <td>
                                                            <select type="text" id="status" name="status" class="form-control" >
                                                                <option value="0" ${book.status == '0' ? 'selected' : ''}>Available</option>
                                                                <option value="1" ${book.status == '1' ? 'selected' : ''}>Reserved</option>
                                                                <option value="2" ${book.status == '2' ? 'selected' : ''}>Out</option>
                                                            </select>
                                                        <td>
                                                            <button type="submit" name="edit" value="${book.idBook}" class="btn btn-primary btn-round">Edit</button>
                                                            <button type="submit" name="delete" value="${book.idBook}" class="btn btn-danger btn-round">Delete</button>
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
