<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />

<h2>Teacher's Page </h2>
<ul>
<c:forEach var="lab" items="${labs}" varStatus="count">
	<li>${lab.sectionName}
	<ol>
	<c:forEach var="child" items="${lab.children}" varStatus="countChildren">
		<li>${child.sectionName}
			<ul>
				<li>Average Score: 100%</li>
				<li>Average Time Spent: 1.2 hours</li>
			</ul>
		</li>
	</c:forEach>
	</ol>
	</li>
</c:forEach>
</ul>
<jsp:directive.include file="/WEB-INF/views/footer.jsp" />