<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="bootstrap/fonts/font-awesome.min.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<title>Welcome Page</title>
	
	<style>
		body {
  		  font-family: "Open Sans", "Segoe UI", Frutiger, "Frutiger Linotype", "Dejavu Sans", "Helvetica Neue", Arial, sans-serif;
		  font-size: 14px;
		  line-height: 1.5em;
		  font-weight: 400;
		}
		
		p, span, a, ul, li, button {
		  font-family: inherit;
		  font-size: inherit;
		  font-weight: inherit;
		  line-height: inherit;
		}
		
		strong {
		  font-weight: 600;
		}
		
		h1, h2, h3, h4, h5, h6 {
		  font-family: "Open Sans", "Segoe UI", Frutiger, "Frutiger Linotype", "Dejavu Sans", "Helvetica Neue", Arial, sans-serif;
		  line-height: 1.5em;
		  font-weight: 300;
		}
		
		strong {
		  font-weight: 400;
		}
		
		.tile {
		  width: 100%;
		  display: inline-block;
		  box-sizing: border-box;
		  background: #fff;
		  padding: 20px;
		  margin-bottom: 30px;
		}
		.tile .title {
		  margin-top: 0px;
		}
		.tile.purple, .tile.blue, .tile.red, .tile.orange, .tile.green {
		  color: #fff;
		}
		.tile.purple {
		  background: #5133ab;
		}
		.tile.purple:hover {
		  background: #3e2784;
		}
		.tile.red {
		  background: #ac193d;
		}
		.tile.red:hover {
		  background: #7f132d;
		}
		.tile.green {
		  background: #00a600;
		}
		.tile.green:hover {
		  background: #007300;
		}
		.tile.blue {
		  background: #2672ec;
		}
		.tile.blue:hover {
		  background: #125acd;
		}
		.tile.orange {
		  background: #dc572e;
		}
		.tile.orange:hover {
		  background: #b8431f;
		}
		
	</style>
</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col-md-12">
	      <h1><strong>Welcome, </strong></h1>
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-sm-4">
	      <div class="tile purple">
	        <h3 class="title">Purple Tile</h3>
	        <p>Hello Purple, this is a colored tile.</p>
	      </div>
	    </div>
	    <div class="col-sm-4">
	      <div class="tile red">
	        <h3 class="title">Red Tile</h3>
	        <p>Hello Red, this is a colored tile.</p>
	      </div>
	    </div>
	    <div class="col-sm-4">
	      <div class="tile orange">
	        <h3 class="title">Orange Tile</h3>
	        <p>Hello Orange, this is a colored tile.</p>
	      </div>
	    </div>
	  </div>
	  <div class="row">
	    <div class="col-sm-4">
	      <div class="tile green">
	        <h3 class="title">Green Tile</h3>
	        <p>Hello Green, this is a colored tile.</p>
	      </div>
	    </div>
	    <div class="col-sm-4">
	      <div class="tile blue">
	        <h3 class="title">Blue Tile</h3>
	        <p>Hello Blue, this is a colored tile.</p>
	      </div>
	    </div>    
	  </div>
	</div>
</body>
</html>