$(document).ready(function() {  
	$('#next').click(function() {
		$('#content').load(window.location+'next');
	});
	$('#prev').click(function(){
		$('#content').load(window.location+'prev');
	});
	$('#new').click(function(){
		alert("Submited!!!");
		$('#content').load(window.location+'new');
	});
	$('#sbmit-answer').click(function(){
		var questNum = $("input:radio").length/2;
		var answers = new Array();
		alert("questNum: "+ questNum);
		alert("number of radio btns: "+ $("input:radio:checked").length);
		if($("input:radio:checked").length != questNum){
			alert("Please answer all the questions!");
		}else{
			var i=0;
			$("input:radio:checked").each(function(){
				answers[i] = $(this).val();
				i++;
			});
			$('#questions').load(window.location+'result/'+$("#sectionId").val(), 'answers='+answers);
		}
	});

});
function clikedAnswer(questionid, optionid, value) {
	
	//alert("Clicked Answer: " + questionid + " SubId: " + optionid + " Value: " + value);
	var span = $(".answers[data-questionid='"+ questionid +"'][data-optionid='"+ optionid + "']");
	span.attr("data-answerd","true");
	span.hide();
	span.html(value);
	span.fadeIn('fast');
	
	//$(".answers[data-questionid='"+ questionid +"'][data-optionid='"+ optionid + "']").html(value).fadeIn(1000);
}
function mainNavigation(id){
	$('#questions').load(window.location+'section', {id: id});
}
function startQuiz(id){
	$("section[data-quiz='"+id+"']").removeClass('hide');
	$("button[data-quiz='"+id+"']").fadeOut('fast');
}
function submitQuiz(quizId){
	var numQuestions = $(".answers[data-quizid='"+quizId+"']").length;
	var unanswerd = $(".answers[data-quizid='"+quizId+"'][data-answerd='false']").length;
	var answerd = $(".answers[data-quizid='"+quizId+"'][data-answerd='true']").length;
	//alert("Quiz: "+quizId+" unanswerd: "+unanswerd+" Answerd: "+answerd); 
	if (numQuestions == answerd){
		var msg = "Congradulations";
		$("#submitResult").html(msg);
		//alert("move on");
	}else {
		var msg = "You left "+unanswerd+" question(s) unanswerd. Do you wish to submit anyway?";
		//alert("You left "+unanswerd+" question(s) unanswerd. Do you wish to submit anyway?");
		$("#submitResult").html(msg);
		
	}
	$("#submitModal").modal('toggle');
	
}

