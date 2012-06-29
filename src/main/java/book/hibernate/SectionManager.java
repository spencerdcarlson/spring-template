package book.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import book.entities.Section;
@Repository
public class SectionManager implements SectionHibInterface {
	
	@Autowired
	private SessionFactory sessionFactory;
	
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
