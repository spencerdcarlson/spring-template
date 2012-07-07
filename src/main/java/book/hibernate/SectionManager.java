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
}
