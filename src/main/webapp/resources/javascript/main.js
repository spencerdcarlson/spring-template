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
	$('#submit-answer').click(function(){
		var questNum = $("input:radio").length/2;
		var answers = new Array();
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
	span.hide();
	span.html(value);
	span.fadeIn(2000);
	
	//$(".answers[data-questionid='"+ questionid +"'][data-optionid='"+ optionid + "']").html(value).fadeIn(1000);
}
function mainNavigation(id){
//	$.get(window.location+'section', {id: id}, function(data){
//		$('#questions').html(data);
//	});
	
	$('#questions').load(window.location+'section', {id: id});
}