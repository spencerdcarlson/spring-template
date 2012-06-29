package book.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import book.entities.Question;
import book.hibernate.QuestionManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionManager questionManager; 
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	private int current = 0;
	private int size; 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String nextQuestion(Locale locale, Model model) {
		// Range of index control
		current++;
		size = questionManager.getSize();
		if ( current > size ) current = 1;		
		Question question = questionManager.getQuestion(current);		
		String[] questionTxt = question.getQuestion().split("//");
		String[] questionOptions = question.getOptions().split("//");
		model.addAttribute("questionTxt",questionTxt);
		model.addAttribute("questionOptions",questionOptions);
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "question";
	}
	
	@RequestMapping(value = "/prev", method = RequestMethod.GET)
	public String prevQuestion(Locale locale, Model model) {
		// Range of index control
		size = questionManager.getSize();
		current--;
		if ( current < 1 ) current = size;
		Question question = questionManager.getQuestion(current);
		String[] questionTxt = question.getQuestion().split("//");
		String[] questionOptions = question.getOptions().split("//");
		model.addAttribute("questionTxt",questionTxt);
		model.addAttribute("questionOptions",questionOptions);
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "question";
	}
}
