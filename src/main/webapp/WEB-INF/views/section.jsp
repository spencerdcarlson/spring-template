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
				<c:forEach var="question" items="${child.questions}"
					varStatus="status">
					<li>
					<table><tr>
					<td width="500px">
						<c:forEach var="quest" items="${fn:split(question.questionTxt, '//')}" varStatus="stat">
							${quest}
							<c:if test="${stat.count!=fn:length(child.questions)}"><span class="answers" data-questionid="${question.questionId}" data-optionid="${stat.count}">____</span>
							</c:if>
						</c:forEach>
					</td>
					<td>(${question.reference})</td>
					</tr></table>
					</li>

					<ol style="list-style-type:none">
						<c:forEach var="option"
							items="${fn:split(question.questionOptions, '//')}" varStatus="stat">
							<!-- DATA-OPTION needs to be a group id it can't be based off of stat.count -->
							<li><input type="radio" class ="answer" name="answer" data-questionid="${question.questionId}" data-optionid="1" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option} </li>
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