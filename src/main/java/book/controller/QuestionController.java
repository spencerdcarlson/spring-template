package book.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import book.entities.Question;
import book.entities.Resource;
import book.entities.Section;
import book.entities.User;
import book.hibernate.PSDataAccess;
import book.hibernate.QuestionManager;
import book.hibernate.SectionManager;
import book.hibernate.UserManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionManager questionManager;
	@Autowired
	private SectionManager sectionManager;
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	private int current = 0;
	private int size;
	@Autowired
	private UserManager userManager;
	@Autowired
	private PSDataAccess ps;
	

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
		String[] questionTxt = question.getQuestionTxt().split("//");
		String[] questionOptions = question.getQuestionOptions().split("//");
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
		String[] questionTxt = question.getQuestionTxt().split("//");
		String[] questionOptions = question.getQuestionOptions().split("//");
		model.addAttribute("questionTxt",questionTxt);
		model.addAttribute("questionOptions",questionOptions);
		model.addAttribute("question", question);
		logger.info("Client recieved QuestionController "+ locale.toString());
		return "question";
	}

	@RequestMapping(value = "/section/{id}", method = RequestMethod.GET)
	public String getSection(@PathVariable("id") String id, Model model, HttpServletRequest request){
		String username = request.getUserPrincipal().getName();
		List<User> userList = userManager.getUser(username);
		User currentUser = userList.get(0);
		// System.out.println("id: " +id);
		String studentName = ps.getStudentName(username);
		int Id = Integer.parseInt(id);
		Section sec = sectionManager.getSection(Id);
		List<Section> children = sectionManager.getSection(Id).getChildren();
		List<Resource> resources = sec.getResources();
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("children", children);
		model.addAttribute("section",sec);
		model.addAttribute("resources",resources);
		model.addAttribute("username", studentName);
		return "section";
	}
	
	@RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
	public String getResult(@PathVariable("id") String id, @RequestParam("answers") String[] answers, Model model, HttpServletRequest request){
//		System.out.println("id: " +id);
		String username = request.getUserPrincipal().getName();
		List<User> userList = userManager.getUser(username);
		User currentUser = userList.get(0);
		String studentName = ps.getStudentName(username);
		
		int Id = Integer.parseInt(id);
		Section sec = sectionManager.getSection(Id);
		currentUser.addCompletedSection(sec);
		userManager.addUser(currentUser);
		
		//userManager.addCompletedSection(currentUser, sec);
		List<Section> children = sectionManager.getSection(Id).getChildren();
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("children", children);
		model.addAttribute("answers", answers);
		model.addAttribute("section",sec);
		model.addAttribute("username", studentName);
		return "result";
	}
	
	@RequestMapping(value = "/score", method = RequestMethod.GET)
	public void saveScore(@RequestParam("section") String section, @RequestParam("score") String score, HttpServletRequest request){
		Section sectionSave = sectionManager.getSection(Integer.parseInt(section));
		Double scoreSave = Double.parseDouble(score);
		String username = request.getUserPrincipal().getName();
		List<User> userList = userManager.getUser(username);
		User currentUser = userList.get(0);
		System.out.println("SAVE Score: "+scoreSave+" TO SECTION: " + sectionSave.getSectionName());
		userManager.addUser(currentUser);
	}
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String getTeacher(Model model, HttpServletRequest request){
		String username = request.getUserPrincipal().getName();
		List<User> userList = userManager.getUser(username);
		User currentUser = userList.get(0);
		String studentName = ps.getStudentName(username);
		List<Section> labs = sectionManager.getSection(1).getChildren();
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("labs",labs);
		model.addAttribute("username", studentName);
		return "teacher";
	}
}
