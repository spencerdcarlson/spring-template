<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />

<h1>${section.sectionName}</h1>

<img src="resources/img/1A-1.JPG" alt="" />
<img src="resources/img/1A-2.JPG" alt="" />

<c:forEach var="child" items="${children}" varStatus="status">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="sectionTitle">${child.sectionName}</h2>
			<p class="sectionInstructions"></p>
			<ol>
				<c:forEach var="question" items="${child.questions}"
					varStatus="status">
					<li><c:forEach var="quest" items="${fn:split(question.questionTxt, '//')}" varStatus="stat">
							${quest}
							<c:if test="${stat.count!=fn:length(child.questions)}">______
							</c:if>
						</c:forEach>
					</li>

					<ol style="list-style-type:upper-alpha">
						<c:forEach var="option"
							items="${fn:split(question.questionOptions, '//')}">
							<li><input type="radio" name="${question.questionId}" value="${option}" />${option}</li>
						</c:forEach>
					</ol>
				</c:forEach>
			</ol>
		</div>
		<!--/span-->
	</div>
	<!-- row-fluid -->
</c:forEach>

<button id='submit-answer' type='button'>Submit</button>
<input type="hidden" value="${section.sectionId}" id="sectionId"/>

<jsp:directive.include file="/WEB-INF/views/footer.jsp" />