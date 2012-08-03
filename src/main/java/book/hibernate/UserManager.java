package book.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import book.entities.Section;
import book.entities.User;

public class UserManager implements UserHibernateInterface {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	// So test's can manually add the sessionFactory
	public void setSession(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser(String username) {
		return getCurrentSession().createQuery("from User where userName='"+username+"'").list();
	}
	
	public List<Section> getProgress(User user){
		return null;
		//return getCurrentSession().createQuery("from User u join u.").list();
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().flush();
		getCurrentSession().save(user);
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCompletedSection(User user, Section section) {
		user.getSectionsCompleted().add(section);
		getCurrentSession().save(user);
	}

}
