package book.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import book.entities.Question;
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
		Section topNode = sectionManager.getSection(1);
		List<Section> mainChildren = sectionManager.getChildren(topNode);
		//String json = sectionManager.getJSONChildren(topNode);
		//System.out.println(json);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
//		for (Question q: sectionManager.getSection(3).questions) {
//			System.out.println("Question: " + q.toString());
//		}
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("section", allSections);
		model.addAttribute("topNode", topNode);
		model.addAttribute("mainChildren", mainChildren);
		model.addAttribute("serverTime", formattedDate );
		
		
		return "index";
		
	}
	
	
	
	
	
}
