<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<section>
	<form method="get">
	Question:
	<c:forEach var="txt" items="${questionTxt}" varStatus="status">
	${txt}
		<c:if test="${status.count != fn:length(questionTxt) || fn:length(questionTxt) == 1 }">
				<select>
					<c:forEach var="opt" items="${questionOptions}">
						<option value="${opt}">${opt}</option>
					</c:forEach>
				</select>
		</c:if>
	</c:forEach>
	<br/><input type="submit"/>
	</form>
</section>
<script>
$('select').prop('selectedIndex', -1);
</script>