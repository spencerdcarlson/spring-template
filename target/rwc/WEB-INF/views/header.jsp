<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.util.*,book.entities.Section"%>
<!DOCTYPE html>
<!-- saved from url=(0055)http://twitter.github.com/bootstrap/examples/fluid.html -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>BYUH: Reading Writing Center</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/bootstrap-responsive.css">
<link rel="stylesheet" href="resources/css/main.css">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon"
	href="http://twitter.github.com/bootstrap/assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="http://twitter.github.com/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
	<script src="./resources/javascript/jquery.js"></script>
	<script src="./resources/javascript/main.js"></script>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="http://localhost:8080/template/">Reading Writing
					Center</a>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="">
						<i class="icon-user"></i> ${username} <span class="caret"></span>
					</a>
					<!-- <ul class="dropdown-menu">
						<li><a href="">Section 1</a></li>
						<li class="divider"></li>
						<li><a href="">Section 2</a></li>
					</ul> -->
				</div><!-- btn-group pull right -->
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="http://byuh.edu/">BYU-H</a></li>
						<li><a href="https://byuh.instructure.com/login">Canvas</a></li>
						<li><a
							href="https://my.byuh.edu/psp/pprod/?cmd=login&amp;languageCd=ENG&amp;">mybyuh</a></li>
					</ul>
				</div><!-- nav-collapse -->
			</div><!-- container-fluid -->
		</div><!-- navbar-inner -->
	</div><!-- navbar navbar-fixed-top -->

	