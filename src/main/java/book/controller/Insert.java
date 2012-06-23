package book.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
			@RequestParam("answer") String answer, @RequestParam("options") String options,  Model model){
	questionManager.addQuestion(question, answer, options);
	model.addAttribute("question", question);
	model.addAttribute("answer", answer);
	model.addAttribute("options", options);
		return "confirm";

	}
}