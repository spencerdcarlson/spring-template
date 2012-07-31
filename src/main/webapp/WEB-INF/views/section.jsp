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

<c:forEach var="quiz" items="${children}" varStatus="quizCount">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="sectionTitle">${quiz.sectionName}</h2>
			<p class="sectionInstructions"></p>
			
			<section data-quiz="${quizCount.count}" class="quizbody">
			<ol>
			<c:forEach var="question" items="${quiz.questions}" varStatus="questionCount">
				
				
				<div class="row">
				<div class="span8">
						<li>
						<c:forEach var="questTxt" items="${fn:split(question.questionTxt, '//')}" varStatus="questTxtCount">
							<c:choose>
								<c:when test="${fn:length(fn:split(question.questionOptions,'//')) > 2}">
									<c:choose>
										<c:when test="${ questTxtCount.count != fn:length(fn:split(question.questionTxt,'//')) || fn:length(fn:split(question.questionTxt,'//')) == 1 }">
											${questTxt}
											<select class="input-mini">
											<c:forEach var="option" items="${fn:split(question.questionOptions, '//')}" varStatus="optionCount">
												<option value="${option}">${option}</option>
											</c:forEach>
											</select>
										</c:when>
										<c:otherwise>
											${questTxt}
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
								${questTxt}
							<c:if test="${ questTxtCount.count != fn:length(fn:split(question.questionTxt,'//')) || fn:length(fn:split(question.questionTxt,'//')) == 1 }">
								<span class="answers" data-quizid="${quizCount.count}" data-questionid="${question.questionId}" data-answerd="false" data-optionid="${questTxtCount.count}">____</span>
							</c:if>
								</c:otherwise>
							</c:choose>
							
						</c:forEach><!-- quest -->
						
					</div>
					<div class="span4">(${question.reference})</div>
					</div><!-- row --></li>
					
					<div class="row">
					
					
					<c:set var="groupId" value="${1}" />
						<div class="span2">
						<c:forEach var="option" items="${fn:split(question.questionOptions, '//')}" varStatus="optionCount">
							<c:choose>
								<c:when test="${optionCount.count % 2 == 0 }" >
									<input type="radio" class ="answer" name="answer${questionCount.count}" data-questionid="${question.questionId}" data-optionid="${groupId}" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option}
									<c:set var="groupId" value="${groupId + 1 }"/>
									</div><div class="span2">
								</c:when>
								<c:otherwise>
									<input type="radio" class ="answer" name="answer${questionCount.count}" data-questionid="${question.questionId}" data-optionid="${groupId}" value="${option}" onClick="clikedAnswer(this.getAttribute('data-questionid'),this.getAttribute('data-optionid'),this.value);" /> ${option}
								</c:otherwise>
							</c:choose>
						</c:forEach><!--  Option -->
						</div>
			</div><!--  row -->
			
				</c:forEach><!-- question -->
			</ol>
			<button  onClick="submitQuiz(this.getAttribute('data-quizid'));" data-quizid="${quizCount.count}" class="btn btn-info" id='submit-answer' type='button'>Submit</button>
			</section><!-- Quiz Body -->
		</div>
		<!--/span12-->
	</div>
	<!-- row-fluid -->
</c:forEach><!-- quiz -->
<section class="modal hide" id="submitModal">
	<button type="button" class="close" data-dismiss="modal">×</button>
	<section class="modal-body">
		<p id="submitResult"></p>
		<a href="#" class="btn" data-dismiss="modal">Close</a>
	</section>
</section>

<input type="hidden" value="${section.sectionId}" id="sectionId"/>

<jsp:directive.include file="/WEB-INF/views/footer.jsp" />