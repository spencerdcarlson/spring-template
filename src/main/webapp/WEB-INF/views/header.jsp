<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<!-- STYLE -->
	<link rel="stylesheet" type="text/css" href="resources/css/main.css" />
	<!-- JAVASCRIPT -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="resources/javascript/main.js"></script> 
</head>
<body>
<header>
	<p>THIS IS THE HEADER</p>
	<nav>
	<table>
	<c:forEach var="sec" items="${section}" varStatus="status">
		<c:choose>
			<c:when test="${ sec.sectionId == sec.parentId }">
				<c:set var="parent" value="${sec.sectionId}" scope="page"></c:set>
				<tr><td>Parent Node:</td><td>${sec.sectionName}</td></tr>
			</c:when>
			
			<c:when test="${sec.parentId == parent }">
					<tr><td>Child Node:</td><td>${sec.sectionName}</td></tr>
					<c:set var="parent" value="${sec.sectionId}" scope="page"></c:set>
			</c:when>
			
		</c:choose>
		
				
		<tr>
		<td>Section Id: ${sec.sectionId}</td>
		<td>Parent Id: ${sec.parentId}</td>
		<td>Section Name: ${sec.sectionName}</td>
		</tr>
	</c:forEach>
	</table>
	</nav>
</header>