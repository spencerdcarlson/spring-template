package book.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import book.entities.Question;



/**
 * An account manager that uses Hibernate to find accounts.
 */
@Repository
public class QuestionManager implements EntityManagerInterface {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Creates a new Hibernate account manager.
	 * @param sessionFactory the Hibernate session factory
	 */
	// So test's can manually add the sessionFactory
	public void setSession(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {
		return getCurrentSession().createQuery("from Question").list();
	}

	
	public Question getQuestion(Integer id) {
		return (Question) getCurrentSession().load(Question.class, id);
	}

	public void update(Question question) {
		getCurrentSession().update(question);
	}
	
	public void updateQuestion(Integer questionId, String question, String answer, String options) {
		Question questionUpdate = getQuestion(questionId);
		if (question != null) questionUpdate.setQuestionTxt(question);
		if (answer != null) questionUpdate.setQuestionAnswer(answer);
		if (options != null) questionUpdate.setQuestionOptions(options);
	}

	public void addQuestion(Question newQuestion ){
		System.out.println("INSERT NEW QUESTION: " + newQuestion.toString());
		getCurrentSession().save(newQuestion);
	}

	public void removeQuestion(Question question) {
		getCurrentSession().delete(question); 
	}

	@SuppressWarnings("unchecked")
	public int getSize(){
		List<Question> qList = getCurrentSession().createQuery("from Question").list();
		return qList.size();
	}

	/**
	 * Returns the session associated with the ongoing reward transaction.
	 * @return the transactional session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
}