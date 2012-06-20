package book.hibernate;

import java.util.List;

import book.entities.Question;


public interface EntityManagerInterface {

	/**
	 * 
	 * @param id id of the desired question to be returned
	 * @return Question with specified id
	 */
	public Question getQuestion(Integer id);
	
	/**
	 * Get all questions in the system
	 * @return all questions
	 */
	public List<Question> getAllQuestions();
	
	/**
	 * Insert new question
	 * @param question new question
	 * @param answer answer to new question
	 * @param options possible options for new question
	 */
	public void addQuestion(String question, String answer, String options);
	
	/**
	 * remove a question based on given id
	 * @param questionId id of the question to delete
	 */
	public void removeQuestion(Integer questionId);
	
	/**
	 * Takes a changed question and persists any changes made to it.
	 * @param question The question with changes
	 */
	public void update(Question question);
	
	/**
	 * Update contents of a question
	 * @param questionId id of the question to update
	 * @param question updated question
	 * @param answer updated answer
	 * @param options updated possibilities for the question
	 */
	public void updateQuestion(Integer questionId, String question, String answer, String options);

	
}
