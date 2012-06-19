package book.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import book.entities.Question;



/**
 * An account manager that uses Hibernate to find accounts.
 */
@Repository
public class QuestionManager implements QuestionManagerInterface {

	private SessionFactory sessionFactory;

	/**
	 * Creates a new Hibernate account manager.
	 * @param sessionFactory the Hibernate session factory
	 */
	public QuestionManager(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {
		return getCurrentSession().createQuery("from Question").list();
	}

	@Transactional(readOnly = true)
	public Question getQuestion(Integer id) {
		return (Question) getCurrentSession().load(Question.class, id);
	}

	@Transactional
	public void update(Question question) {
		getCurrentSession().update(question);
	}
	
	@Transactional
	public void updateQuestion(Integer questionId, String question, String answer, String options) {
		Question questionUpdate = getQuestion(questionId);
		if (question != null) questionUpdate.setQuestion(question);
		if (answer != null) questionUpdate.setAnswer(answer);
		if (options != null) questionUpdate.setOptions(options);
	}

	@Transactional
	public void addQuestion(String question, String answer, String options) {
		// getCurrentSession() . insert options
	}

	@Transactional
	public void removeQuestion(Integer questionId) {
		// getCurrentSession() remove questionId 
	}
	
	@Transactional
	public Question getNextQuestion(Question current) {
		Integer currentId = current.getId();
		currentId++;
		return getQuestion(currentId);
	}

	@Transactional
	public Question getPreviousQuestion(Question current) {
		Integer currentId = current.getId();
		currentId--;
		return getQuestion(currentId);
	}

	/**
	 * Returns the session associated with the ongoing reward transaction.
	 * @return the transactional session
	 */
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
}