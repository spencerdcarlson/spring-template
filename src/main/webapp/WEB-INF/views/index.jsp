<jsp:directive.include file="/WEB-INF/views/header.jsp" />
<section>
	<h1>Application Launch</h1>
	<p>The time on the server is ${serverTime}.</p>
</section>
<section id='content'></section>
<section>
	<button id='prev' type='button'>Prev</button>
	<button id='next' type='button'>Next</button>
</section>
<section>
	<button id='new' type='button'>New</button>
</section>
<jsp:directive.include file="/WEB-INF/views/footer.jsp" />