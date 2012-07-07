<jsp:directive.include file="/WEB-INF/views/header.jsp" />

<div class="container-fluid">
      <div class="row-fluid">
        
        <div class="span3">
          <div class="well sidebar-nav">
           <ul class="nav nav-list">
              <!-- Nav Items -->
              <li class="nav-header">Quizes</li>

              <!-- 
              <li class="dropdown active" id="menu1">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#menu1">
                Microlab 1A Quiz - Apostrophes
                <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                  <li><a href="#">Section 1</a></li>
                  <li><a href="#">Section 2</a></li>
                </ul>
              </li>
              -->
              <c:forEach var="section" items="${nav}" varStatus="status">
              <li><a onclick="mainNavigation(this.id);" id="${section.sectionId}" >${section.sectionName}</a></li>
              </c:forEach>
            </ul>
          </div><!--/.well -->
        </div><!--/span3-->
        
        <div class="span9">
          <div id="lesson" class="hero-unit">
          
            <h1>Quiz Instruction</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-large">Learn more »</a></p>
            
          </div><!--  -->
          <section id="questions"></section>
          </div><!--/span9-->
          
      </div><!--/row-->
      
      </div>
    

      <hr>
      
      
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