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
    <div class="main-panel">
        <div class="content">
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="card card-nav-tabs">
                        <div class="card-header" data-background-color="purple">
                            <div class="nav-tabs-navigation">
                                <div class="nav-tabs-wrapper">
                                <form>
                                    <ul class="nav nav-tabs" data-tabs="tabs">
                                        <div class="col-md-3">
                                            <li class="">
                                                <div class="form-group label-floating">
                                                    <select type="text" class="form-control text-white">
                                                        <option class="text-black">Search by</option>
                                                        <option class="text-black" value="Title">Id Number</option>
                                                        <option class="text-black" value="Author">Status</option>
                                                        <option class="text-black" value="Author">Date</option>
                                                        <option class="text-black" value="Publisher">Time</option>
                                                        <option class="text-black" value="Year">Day</option>
                                                    </select>
                                                </div>
                                            </li>
                                        </div>
                                        <div class="col-md-6">
                                            <li class="">
                                                <div class="form-group label-floating">
                                                    <input type="text" class="form-control text-white">
                                                </div>
                                            </li>
                                        </div>
                                        <div class="col-md-3">
                                            <li class="">
                                                <div class="form-group label-floating">
                                                    <button href="#" class="btn btn-success pull-right btn-round" style="margin-top: -0.5em; margin-right: 2em;">Search</button>
                                                </div>
                                            </li>
                                        </div>
                                    </ul>
                                </form>
                                </div>
                            </div>
                        </div>

                        <div class="card-content">
                            <div class="tab-content">
                                <div class="tab-pane active" id="">
                                    <div class="card-content table-responsive">
                                        <table class="table table-hover">
                                            <thead class="text-warning">
                                                <th>Room number</th>
                                                <th>Id number</th>
                                                <th>Date</th>
                                                <th>Time</th>
                                                <th>Day</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><input type="number" value="1"></td>
                                                    <td><input type="number" value="11200000"></td>
                                                    <td><input type="text" value="07/31/2017"></td>
                                                    <td><input type="text" value="4:00 PM"></td>
                                                    <td><input type="text" value="Sunday"></td>
                                                    <td>
                                                        <select>
                                                            <option>Reserved</option>
                                                            <option>Available</option>
                                                        </select>
                                                    </td>
                                                    <td><button href="#" class="btn btn-primary btn-round">Edit</button></td>
                                                </tr>
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