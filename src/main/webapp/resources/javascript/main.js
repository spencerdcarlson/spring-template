$(document).ready(function() {  
	$('header').click(function() {
		alert("JQuery Enabled: You Clicked the Header");
	});
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
			$('#questions').load('/edu/result/'+$("#sectionId").val(), 'answers='+answers);
		}
	});

});

function mainNavigation(id){
//	$.get(window.location+'section', {id: id}, function(data){
//		$('#questions').html(data);
//	});
	
	$('#questions').load('/edu/section/'+id);
}