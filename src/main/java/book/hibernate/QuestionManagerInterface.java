package book.hibernate;

import java.util.List;

import book.entities.Question;


public interface QuestionManagerInterface {

	/**
	 * Get all questions in the system
	 * @return all questions
	 */
	public List<Question> getAllQuestions();

	/**
	 * Return the next Question.
	 * @param current current question
	 * @return the question
	 */
	public Question getNextQuestion(Question current);

	/**
	 * Return the previous Question.
	 * @param current current question
	 * @return the question
	 */
	public Question getPreviousQuestion(Question current);
	
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
