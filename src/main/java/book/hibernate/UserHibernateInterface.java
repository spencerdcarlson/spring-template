package book.hibernate;

import book.entities.User;

public interface UserHibernateInterface {
	
	public User getUser(String username);
	
	public void createUser(User user);
}
