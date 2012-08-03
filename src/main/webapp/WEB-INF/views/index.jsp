<jsp:directive.include file="/WEB-INF/views/header.jsp" />

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<div class="well sidebar-nav">
				<ul class="nav nav-list">
					<!-- Nav Items -->
					<li class="nav-header"><a href="">Microlab Quizzes</a></li>
					
					<c:forEach var="section" items="${nav}" varStatus="status">
						<c:choose>
							<c:when test="${fn:length(currentUser.sectionsCompleted) > 0 }">
								<c:forEach var="sectionComplete" items="${currentUser.sectionsCompleted}" varStatus="compCount">
									<c:choose>
										<c:when test="${sectionComplete.sectionId ==  section.sectionId }" >
											<!-- onclick='seeScore(this.id);' -->
											<li><a onclick="seeScore(this.id);" id="${section.sectionId}">${section.sectionName} <i class="icon-ok"></i></a></li>
										</c:when>
										<c:otherwise>
											<li><a onclick="mainNavigation(this.id);" id="${section.sectionId}">${section.sectionName}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<li><a onclick="mainNavigation(this.id);" id="${section.sectionId}">${section.sectionName}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
				</ul>
			</div>
			<!--well -->
		</div>
		<!-- span3 -->
		<div class="span9">
			<section id="questions">
				<h1>Microlab</h1>
				<img
						src="http://readingwritingcenter.byuh.edu/sites/readingwritingcenter.byuh.edu/files/u390/RWC%20front.jpg" alt="welcom banner" />

			</section>
			
		</div>
		<!--span9-->
	</div>
	<!--row fluid-->
	<p>USER: ${currentUser.userName} ID: ${currentUser.userId}<p>
	
</div> <!-- container fluid -->
<hr>
<jsp:directive.include file="/WEB-INF/views/footer.jsp" />