package book.controller;

import java.io.IOException;
import java.util.Locale;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoaderListener;

import book.entities.Question;
import book.hibernate.QuestionManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class Insert {

	@Autowired
	private QuestionManager questionManager;	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	private int current = 1;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String form(Locale locale, Model model) {
		return "form";
	}
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submit(@RequestParam("question") String question, 
			@RequestParam("answer") String answer, 
			@RequestParam("options") String options, 
			@RequestParam("sectionId") String sectionId,  Model model){
		try{
			Integer sId = Integer.parseInt(sectionId);
			Question newQuestion = new Question(sId,question,answer,options);
			questionManager.addQuestion(newQuestion);
		}catch(NumberFormatException e) {
			System.out.println("New question wasn't inserted into the DB: " + e);
		}
		model.addAttribute("sectionId", sectionId);
		model.addAttribute("question", question);
		model.addAttribute("answer", answer);
		model.addAttribute("options", options);
		return "confirm";

	}

	@RequestMapping(value = "/json/{question}", method = RequestMethod.GET)
	public @ResponseBody Question question2Json(@PathVariable String question) {
		ObjectMapper mapper = new ObjectMapper();
		Question newQuestion;
		try {
			// Map JSON string to Java Object
			newQuestion = mapper.readValue(question, Question.class);
			System.out.println("Question: " + newQuestion.toString());
			// Insert Java Object into Database 
			//newQuestion.setId(10); // if id isn't set to @JsonIgnore
			questionManager.addQuestion(newQuestion);
			return newQuestion;
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Question newQuestion = new Question(question);
		return null;
	}
}