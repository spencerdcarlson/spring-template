package book.hibernate;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import book.entities.Question;
import book.entities.Section;
import book.entities.Instruction;
@Repository
public class SectionManager implements SectionHibInterface {

	@Autowired
	private SessionFactory sessionFactory;
	private static String jsonSectionChildList = "";
	private static String jsonQuestionList = "";
	private Gson gson = new Gson();

	// So test's can manually add the sessionFactory
	public void setSession(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Section getSection(Integer id){
		return (Section) getCurrentSession().load(Section.class, id);
	}


	@SuppressWarnings("unchecked")
	public List<Section> getAllSections(){
		return getCurrentSession().createQuery("from Section").list();
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public String getJSONChildren(Section section){
		section.children = (List<Section>) getCurrentSession().createQuery("from Section s where s.parentId="+section.getSectionId()).list();
		for (Section s: section.children){
			if (s.getInstructionId() != null) {
				s.instruction = (Instruction) getCurrentSession().load(Instruction.class, Integer.parseInt(s.getInstructionId()));
			}
			if (s.getHasChild() == 1 ) {
				getChildren(s);
			}else {
				s.questions =  (List<Question>) getCurrentSession().createQuery("from Question q where q.sectionId="+s.getSectionId()).list();
			}
		}
		
		return gson.toJson(section);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Section> getChildren(Section section) {
		List<Section> childList =  (List<Section>) getCurrentSession().createQuery("from Section s where s.parentId="+section.getSectionId()).list();
		return childList;

	}


	@Override
	public Section getPareent(Section section) {
		return (Section) getCurrentSession().createSQLQuery("SELECT * FROM section WHERE section_id=" + section.getSectionId());
	}

	public static boolean isNumeric(String str){
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}



}
