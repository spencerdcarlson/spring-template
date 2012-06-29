package book.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import book.entities.Section;
import book.hibernate.SectionManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class Home {
	
	@Autowired
	private SectionManager sectionManager;
	private static final Logger logger = LoggerFactory.getLogger(Home.class);
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		List<Section> allSections = sectionManager.getAllSections();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("section", allSections);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
		
	}
	
}
