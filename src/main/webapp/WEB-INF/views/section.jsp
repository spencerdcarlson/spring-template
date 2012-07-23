<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />

<h2>${section.sectionName}</h2>

<c:forEach var="res" items="${resources}" varStatus="varstatus">
	<img src="resources/img/${res.resourceName}.JPG" alt="" />
</c:forEach>

<c:forEach var="child" items="${children}" varStatus="status">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="sectionTitle">${child.sectionName}</h2>
			<p class="sectionInstructions"></p>
			<ol>
			<c:forEach var="question" items="${child.questions}" varStatus="status">
				<li><table>
					<tr>
					<td width="500px">
						
						<c:forEach var="quest" items="${fn:split(question.questionTxt, '//')}" varStatus="stat">
							${quest}
							<c:if test="${ stat.count != fn:length(fn:split(question.questionTxt,'//')) || fn:length(fn:split(question.questionTxt,'//')) == 1 }">
								<span class="answers" data-questionid="${question.questionId}" data-optionid="${stat.count}">____</span>
							</c:if>
						</c:forEach>
						
					</td>
					<td>(${question.reference})</td>
					</tr>
					<tr>
					
					
					<c:set var="groupId" value="${1}" />
						<td>
						<c:forEach var="option" items="${fn:split(question.questionOptions, '//')}" varStatus="stat">
							<c:choose>
								<c:when test="${stat.count % 2 == 0 }" >
									<input type="radio" class ="answer" name="answer${groupId}" data-questionid="${question.questionId}" data-optionid="${groupId}" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option}
									<c:set var="groupId" value="${groupId + 1 }"/>
									</td><td>
								</c:when>
								<c:otherwise>
									<input type="radio" class ="answer" name="answer${groupId}" data-questionid="${question.questionId}" data-optionid="${groupId}" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option}
								</c:otherwise>
							</c:choose>
						</c:forEach>
						</td>
			</tr>
			</table></li>
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