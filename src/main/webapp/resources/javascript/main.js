$(document).ready(function() {  
	var incorrect = $(".grade[data-graded='0']").length;
	var correct = $(".grade[data-graded='1']").length;
	var score = 100 * (correct / (incorrect + correct));
	score = score.toPrecision(3);
	$('#resultDone').attr('data-score', score);
	$("#score").html("<strong>Score: "+score+"%</strong>");
	
	
	
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
			$('#questions').load('/edu/result/'+$("#sectionId").val(), 'answers='+answers);
		}
	});

});

function addScore(sectionSave, scoreSave){
	alert("Add Score: " + scoreSave + " To Section: " + sectionSave);
	$.ajax({
		type: "GET",
		url: window.location+"score",
		data: { section: sectionSave, score: scoreSave }
	});
	//	$.get(
//			window.location+"score",
//			"{section:"+section+", score:"+score+"}",
//			function(data){alert("Sucess");}
//			
//	);
	
}


function clikedAnswer(questionid, optionid, value) {
	
	//alert("Clicked Answer: " + questionid + " SubId: " + optionid + " Value: " + value);
	var span = $(".answers[data-questionid='"+ questionid +"'][data-optionid='"+ optionid + "']");
	span.attr("data-answerd","true");
	span.hide();
	span.html(value);
	span.fadeIn('fast');

}

//$(".answers[data-questionid='"+ questionid +"'][data-optionid='"+ optionid + "']").html(value).fadeIn(1000);

function mainNavigation(id){
	$('#questions').load('/template/section/'+id);
}
function startQuiz(id){
	$("section[data-quiz='"+id+"']").removeClass('hide');
	$("button[data-quiz='"+id+"']").fadeOut('fast');
}
function seeScore(sectionId){
	
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


function quizDone() {
	var answers = getAnswers();
	var questions = $(".answers").length;
	if (answers.length < questions ){
		alert("Please answer all the questions");
	}else {
		// Check for all answer selected
		
		// Load quiz report
		var id = $('#mainSection').attr('data-sectionId');
		$('#questions').load('/template/result/'+id, 'answers='+answers);
	}
}



function getAnswers(){
	var answers = new Array();
	var i = 0;
	$(".answer:checked").each(function(){
		answers[i] = $(this).val();
		i++;
	});
	return answers;
}


