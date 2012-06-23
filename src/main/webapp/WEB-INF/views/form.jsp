<h1>New Question</h1>
<form method="get">
	<label for="question">Question:</label> <input id="question"
		type="text" name='question' required='required' /><br /> <label
		for="answer">Answer:</label> <input id="answer" type="text"
		name='answer' required='required' /> <br /> <label for="options">Options:</label>
	<input id="options" type="text" name='options' required='required' /><br />
	<button type='submit'>Submit</button>
</form>
<script>
	/* Redirect form contents */
	$('form').get(0).setAttribute('action', window.location + 'submit');
</script>
