package book.controller;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoaderListener;
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
	private int current = 1;
	private int size; 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String nextQuestion(Locale locale, Model model) {
		// Range of index control
		size = questionManager.getSize();
		if ( current > size ) current = 1;		
		Question question = questionManager.getQuestion(current);
		current++;		
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "question";
	}
	
	@RequestMapping(value = "/prev", method = RequestMethod.GET)
	public String prevQuestion(Locale locale, Model model) {
		// Range of index control
		size = questionManager.getSize();
		if ( current > size ) current = 1;
		Question question = questionManager.getQuestion(current);
		current--;
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "question";
	}
}
