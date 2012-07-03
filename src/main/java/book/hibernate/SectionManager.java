package book.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import book.entities.Question;
import book.entities.Section;
@Repository
public class SectionManager implements SectionHibInterface {

	@Autowired
	private SessionFactory sessionFactory;

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
	@Override
	public List<Section> getChildren(Section section) {
		return (List<Section>) getCurrentSession().createQuery("from Section s where s.parentId="+section.getSectionId()).list();
		/*
		List<Section> all = getAllSections();
		ArrayList<Section> children = new ArrayList<Section>();
		for (Section s: all){
			if (section.getSectionId() == s.getSectionId()) children.add(s);
		}
		return children;
		*/
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> getquestions(Section section){
		return (List<Question>) getCurrentSession().createQuery("from Question q where q.sectionId="+section.getSectionId()).list();
		 
	}

	@Override
	public Section getPareent(Section section) {
		return (Section) getCurrentSession().createSQLQuery("SELECT * FROM section WHERE section_id=" + section.getSectionId());
	}


}
