package book.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import book.entities.Section;
import book.entities.User;

public class UserManager implements UserHibernateInterface {

	@Autowired
	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;
	
	// So test's can manually add the sessionFactory
	public void setSession(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User getUser(String username) {
		return (User) getCurrentSession().load(User.class, username);
	}

	@Override
	public void createUser(User user) {
		hibernateTemplate.saveOrUpdate(user);
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
