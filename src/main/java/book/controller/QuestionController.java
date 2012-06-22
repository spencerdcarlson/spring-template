package book.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import book.entities.Question;
import book.hibernate.QuestionManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QuestionController {
	
	//@Autowired
	private QuestionManager questionManager = (QuestionManager) new ContextLoaderListener().getCurrentWebApplicationContext().getBean(QuestionManager.class);
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	private int current = 0;
	private int size = questionManager.getSize();
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/next", method = RequestMethod.GET)
	public String nextQuestion(Locale locale, Model model) {
		current = current + 1 % size;
		Question question = questionManager.getQuestion(current);
		
		System.out.println("Current: " + current);
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "next";
	}
	
	@RequestMapping(value = "/prev", method = RequestMethod.GET)
	public String prevQuestion(Locale locale, Model model) {
		Question question = questionManager.getQuestion(current);
		current--;
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "next";
	}
	
}
