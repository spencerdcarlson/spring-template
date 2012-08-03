package book.hibernate;

import java.util.List;

import book.entities.Section;
import book.entities.User;

public interface UserHibernateInterface {
	
	//public User getUser(Integer username);
	
	public void addUser(User user);
	
	public List<Section> getProgress(User user);

	public List<User> getUser(String username);
	
	public void addCompletedSection(User user, Section section);
}
