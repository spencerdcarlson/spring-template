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
		$('#content').load(window.location+'new');
	});

	
});