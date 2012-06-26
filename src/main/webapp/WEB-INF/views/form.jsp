<h1>New Question</h1>
<form id="newQuestion" method="get">
	<label for="question">Question:</label> <input id="question"
		type="text" name='question' required='required' /><br /> <label
		for="answer">Answer:</label> <input id="answer" type="text"
		name='answer' required='required' /> <br /> <label for="options">Options:</label>
	<input id="options" type="text" name='options' required='required' /><br />
	<button type='submit'>Submit</button>
</form>
<section id="result">
	<p>Result will show up here</p>
</section>

<script>
	/* Form-to-json-object */
	/* call $('#formName').serializeObject() */
	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};

	$('#newQuestion').submit(function() {
		alert('form submited Mahalo');
		var contents = JSON.stringify($('#newQuestion').serializeObject());
		alert(contents);
		$('#content').load(window.location+'json/'+contents);
		return false;
	});
</script>