<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:directive.include file="/WEB-INF/views/header.jsp" />

<h2>${section.sectionName}</h2>
<a data-toggle="modal" href="#myModal" class="btn btn-primary">Show Reading</a>

<section class="modal hide fade" id="myModal">
	<button type="button" class="close" data-dismiss="modal">×</button>
	<a  style="padding: 5px 5px 5px 5px;" type="button" >open in new tab</a>
	<section class="modal-header" style="height: 10px;">
	</section>
	<section class="modal-body" style="height: 500px;">
	<c:forEach var="res" items="${resources}" varStatus="varstatus">
		<img src="resources/img/${res.resourceName}.JPG" alt="" />
	</c:forEach>
	</section>
	<section class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">Close</a>
	</section>
</section>

<c:forEach var="child" items="${children}" varStatus="status">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="sectionTitle">${child.sectionName}</h2>
			<p class="sectionInstructions"></p>
			
			<a id="${status.count}" onClick="startQuiz(this.id);" class="btn btn-success">Start Quiz</a>
			<section id="${status.count}" class="quizbody" style="display: none;">
			<ol>
			<c:forEach var="question" items="${child.questions}" varStatus="status">
				
				
				<div class="row">
				<div class="span8">
						<li>
						<c:forEach var="quest" items="${fn:split(question.questionTxt, '//')}" varStatus="stat">
							<c:choose>
								<c:when test="${fn:length(fn:split(question.questionOptions,'//')) > 2}">
									<c:choose>
										<c:when test="${ stat.count != fn:length(fn:split(question.questionTxt,'//')) || fn:length(fn:split(question.questionTxt,'//')) == 1 }">
											${quest}
											<select class="input-mini">
											<c:forEach var="option" items="${fn:split(question.questionOptions, '//')}" varStatus="stat">
												<option value="${option}">${option}</option>
											</c:forEach>
											</select>
										</c:when>
										<c:otherwise>
											${quest}
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
								${quest}
							<c:if test="${ stat.count != fn:length(fn:split(question.questionTxt,'//')) || fn:length(fn:split(question.questionTxt,'//')) == 1 }">
								<span class="answers" data-questionid="${question.questionId}" data-optionid="${stat.count}">____</span>
							</c:if>
								</c:otherwise>
							</c:choose>
							
						</c:forEach>
						
					</div>
					<div class="span4">(${question.reference})</div>
					</div><!-- row --></li>
					
					<div class="row">
					
					
					<c:set var="groupId" value="${1}" />
						<div class="span2">
						<c:forEach var="option" items="${fn:split(question.questionOptions, '//')}" varStatus="stat">
							<c:choose>
								<c:when test="${stat.count % 2 == 0 }" >
									<input type="radio" class ="answer" name="answer${status.count}" data-questionid="${question.questionId}" data-optionid="${groupId}" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option}
									<c:set var="groupId" value="${groupId + 1 }"/>
									</div><div class="span2">
								</c:when>
								<c:otherwise>
									<input type="radio" class ="answer" name="answer${status.count}" data-questionid="${question.questionId}" data-optionid="${groupId}" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option}
								</c:otherwise>
							</c:choose>
						</c:forEach>
						</div>
			</div><!--  row -->
			
				</c:forEach>
			</ol>
			<button  class="btn btn-info" id='submit-answer' type='button'>Submit</button>
			</section><!-- Quiz Body -->
		</div>
		<!--/span12-->
	</div>
	<!-- row-fluid -->
</c:forEach>


<input type="hidden" value="${section.sectionId}" id="sectionId"/>

<jsp:directive.include file="/WEB-INF/views/footer.jsp" />