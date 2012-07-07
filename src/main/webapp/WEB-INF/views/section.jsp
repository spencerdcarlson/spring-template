<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:forEach var="child" items="${children}" varStatus="status">
		<div class="row-fluid">
			<div class="span12">
				<h2 class="sectionTitle">${child.sectionName}</h2>
				<p class="sectionInstructions"></p>
			
				<ol>
				
				<c:forEach var="question" items="${child.questions}" varStatus="status">
					<li>${status.count} Question</li>
				</c:forEach>
			
				</ol>
			</div><!--/span-->
		</div><!-- row-fluid -->
	</c:forEach>

