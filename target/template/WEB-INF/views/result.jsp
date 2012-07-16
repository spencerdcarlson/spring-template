<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h1>${section.sectionName}</h1>
<c:set value="0" var="i"/>
<c:forEach var="child" items="${children}" varStatus="status">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="sectionTitle">${child.sectionName}</h2>
			<p class="sectionInstructions"></p>
			<ol>
				<c:forEach var="question" items="${child.questions}"
					varStatus="questionNum">
					<li><c:forEach var="quest" items="${fn:split(question.questionTxt, '//')}" varStatus="stat">
							${quest}
							<c:if test="${stat.count!=fn:length(child.questions)}">______
							</c:if>
						</c:forEach>
					</li>
${i}
					<ol style="list-style-type:upper-alpha">
						<c:forEach var="option"
							items="${fn:split(question.questionOptions, '//')}">
							
							<c:choose>
							<c:when test="${option==answers[i]}">
								<c:choose>
									<c:when test="${option==question.questionAnswer}">
										<li><span style="font-weight:bold; color:green">${option}</span></li>
									</c:when>
									<c:otherwise>
										<li><span style="font-weight:bold; color:red">${option}</span></li>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise><li>${option}</li></c:otherwise>
							</c:choose>
							
						</c:forEach>
					</ol>
					<c:set value="${i+1}" var="i"/>
				</c:forEach>
			</ol>
		</div>
		<!--/span-->
	</div>
	<!-- row-fluid -->
</c:forEach>