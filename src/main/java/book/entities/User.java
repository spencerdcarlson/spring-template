package book.entities;

import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private int userId;
	@Column(name = "user_name")
	private String userName;
	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Section> sectionsCompleted;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Section> getSectionsCompleted() {
		return sectionsCompleted;
	}
	public void setSectionsCompleted(List<Section> sectionsCompleted) {
		this.sectionsCompleted = sectionsCompleted;
	}
	public void addCompletedSection(Section section){
		this.sectionsCompleted.add(section);
	}
	
	
	

}
